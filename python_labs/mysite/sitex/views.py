import requests
from django.conf import settings
from django.contrib.auth.models import AnonymousUser
from django.contrib.auth import authenticate, login
from django.http import HttpResponse
from django.shortcuts import render, redirect
from django.utils.http import url_has_allowed_host_and_scheme
from .models import UserLastCurrency
from .forms import UserForm, RegisterForm, LoginForm, convertForm


# Create your views here.


def index(request):
    userform = UserForm()
    return render(request,'index.html',{'form':userform})


def home(request):
    if request.user.is_anonymous:
        return render(request, 'main.html')

    if request.method == "POST":
        form = convertForm(request.POST)
        if form.is_valid():
            print('valid')
            currency1 = form.cleaned_data['fcurrency']
            currency2 = form.cleaned_data['tcurrency']
            amount = form.cleaned_data['amount']

            if amount < 0:
                return render(request, 'main.html', {
                    'form': form,
                    'name': request.user.nickname,
                    'result': "Сумма должна быть положительной"
                })
            print(currency1,currency2)

            url = f"https://api.frankfurter.dev/v1/latest?base={currency1}&symbols={currency2}&amount={amount}"
            print(url)

            resp = requests.get(url).json()

            updated_values = {
                'amount': amount,
                'currencyfrom': currency1,
                'currencyto': currency2,
            }
            UserLastCurrency.objects.update_or_create(
                user_id=request.user.id,
                defaults=updated_values
            )
            print(resp)

            context = {
                'form': form,
                'name': request.user.nickname,
                'result': resp.get('rates', 'Ошибка API').get(currency2,'Ошибка API'),
            }
            return render(request, 'main.html', context)
        else:
            print("Ошибки формы:", form.errors)
    else:
        form = convertForm()

    return render(request, 'main.html', {
        'form': form,
        'name': request.user.nickname
    })


def profile_page(request):
    info = UserLastCurrency.objects.get(user_id=request.user.id)
    context = {
        'name': request.user.nickname,
        'email': request.user.email,
        'role': request.user.role,
        'fcurrency': info.currencyfrom,
        'tcurrency': info.currencyto,
        'amount': info.amount,
    }
    return render(request,'profile.html',context)

def register_page(request):
    form = RegisterForm(request.POST or None)
    context = {
        'form':form,
    }
    if form.is_valid():
        form.save()
        return redirect('/login')
    return render(request,'register.html',context)


def login_page(request):
    form = LoginForm(request.POST or None)
    context = {
        'form':form,
    }
    next_ = request.GET.get('next')
    next_post = request.POST.get('next')
    redirect_path = next_ or next_post or None
    if form.is_valid():
        email = form.cleaned_data.get('email')
        password = form.cleaned_data.get('password')
        user = authenticate(request, email=email, password=password)
        if user is not None:
            login(request, user)
            try:
                del request.session['guest_email_id']
            except:
                pass
            if url_has_allowed_host_and_scheme(redirect_path,request.get_host()):
                return redirect(redirect_path)
            else:
                redirect('/')
    return render(request,'login.html',context)
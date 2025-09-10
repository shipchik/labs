from django.contrib.auth.models import AnonymousUser
from django.contrib.auth import authenticate, login
from django.http import HttpResponse
from django.shortcuts import render, redirect
from django.utils.http import url_has_allowed_host_and_scheme

from .forms import UserForm, RegisterForm, LoginForm


# Create your views here.


def index(request):
    userform = UserForm()
    return render(request,'index.html',{'form':userform})


def home(request):
    if request.user == AnonymousUser():
        return render(request,'main.html',)
    return render(request,'home.html', {'name': request.user.nickname})

def profile_page(request):
    context = {
        'name': request.user.nickname,
        'email': request.user.email,
        'role': request.user.role,
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
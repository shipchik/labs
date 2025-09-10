from django import forms

from .models import User


class UserForm(forms.Form):
    name = forms.CharField()
    age = forms.IntegerField()


class RegisterForm(forms.ModelForm):
    email = forms.CharField(widget=forms.EmailInput(attrs={'placeholder': 'Email', 'class': 'regform'}),label='Email')
    nickname = forms.CharField(widget=forms.TextInput(attrs={'placeholder': 'Nickname', 'class': 'regform'}),label='Nickname')
    password1 = forms.CharField(widget=forms.PasswordInput(attrs={'placeholder': 'Password', 'class': 'regform'}),label='Password')
    password2 = forms.CharField(widget=forms.PasswordInput(attrs={'placeholder': 'Confirm Password', 'class': 'regform'}),label='Confirm Password')
    class Meta:
        model = User
        fields = ('email', 'nickname',)

    def clean_password2(self):
        password1 = self.cleaned_data.get("password1")
        password2 = self.cleaned_data.get("password2")
        if password1 and password2 and password1 != password2:
            raise forms.ValidationError("Passwords don't match")
        return password2
    def save(self, commit=True):
        user = super(RegisterForm, self).save(commit=False)
        user.set_password(self.cleaned_data["password1"])
        user.active = False
        if commit:
            user.save()
        return user


class LoginForm(forms.Form):
    email = forms.EmailField(label='Email',widget=forms.EmailInput(attrs={
        'placeholder': 'Email',
        'class': 'logform',
    }))
    password = forms.CharField(label='Password',widget=forms.PasswordInput(attrs={
        'placeholder': 'Password',
        'class': 'logform',
    }))

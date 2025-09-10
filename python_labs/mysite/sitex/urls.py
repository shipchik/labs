from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('registration', views.register_page, name='registration'),
    path('login', views.login_page, name='login'),
    path('profile', views.profile_page, name='profile'),
]
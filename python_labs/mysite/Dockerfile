# 1. Базовый образ с Python
FROM python:3.11-slim

# 2. Установка зависимостей ОС
RUN apt-get update && apt-get install -y \
    build-essential \
    libpq-dev \
    && rm -rf /var/lib/apt/lists/*

# 3. Установка рабочей директории
WORKDIR /app

# 4. Копирование файла зависимостей
COPY requirements.txt /app/

# 5. Установка зависимостей Python
RUN pip install --upgrade pip
RUN pip install -r requirements.txt

# 6. Копирование исходного кода проекта
COPY . /app/

# 7. Настройка переменных окружения для Python
ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

# 8. Открытие порта
EXPOSE 8000

# 9. Команда запуска приложения (для разработки)
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]

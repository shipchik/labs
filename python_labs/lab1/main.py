import random
import sys

from task5 import FruitGarden, AppleGarden, PearGarden
from task3 import convert_string
from task2 import sort
from task1 import IsOddNumber


def first_task():
    number = int(input("Enter a number: "))
    print(IsOddNumber(number))
    random_number = [random.randint(1, 100) for _ in range(5)]
    print(random_number)
    for number in random_number:
        print(number,"is Odd:",IsOddNumber(number))

def second_task():
    sort_numbers1 = [random.randint(1, 100) for _ in range(3)]
    sort_numbers2 = [random.randint(1, 100) for _ in range(3)]
    print("numbers 1: ",sort_numbers1)
    print("numbers 2: ",sort_numbers2)
    print("sorted numbers1: ",sort(sort_numbers1))
    print("sorted numbers2: ",sort(sort_numbers2))


def third_task():
    input_string = str(input("Enter a string: "))
    converted_string = convert_string(input_string)
    if converted_string.replace(" ","") == "":
        print("Строка стала нечитаемой после удаления цифр.")
    else:
        print(converted_string)

def fourth_task():
    string = str(input("Enter a float number: "))
    first_n = int(input("Enter a first_n: "))
    last_m = int(input("Enter a last_m: "))
    if '.' not in string:
        print("Строка должна содержать десятичную точку")
        return 1

    integer, fractional = string.split('.', 1)

    int_part = integer[:first_n]

    frac_part = fractional[-last_m:] if last_m > 0 else ''

    print(int_part + ('.' + frac_part if frac_part else ''))

def fifth_task():
    fruit_garden = FruitGarden(10,10)
    apple_garden = AppleGarden(20,20)
    pear_garden = PearGarden(30,30)
    fruit_garden.info()
    apple_garden.info()
    pear_garden.info()
    apple_garden.increaseTreeCount()
    pear_garden.increaseTreeCount()
    apple_garden.info()
    pear_garden.info()
    apple_garden.decreaseTreeCount()
    pear_garden.decreaseTreeCount()
    apple_garden.info()
    pear_garden.info()
    apple_garden.special_info()
    pear_garden.special_info()


def main(args=None):
    if args is None:
        print("no args")
        return 0
    match int(args):
        case 1:
            first_task()
        case 2:
            second_task()
        case 3:
            third_task()
        case 4:
            fourth_task()
        case 5:
            fifth_task()


if __name__ == '__main__':
    main(*sys.argv[1:])
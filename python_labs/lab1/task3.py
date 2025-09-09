import re


def convert_string(input_string):
    return re.sub(r'\d','',input_string)


def sort(*args):
    nums = []

    for arg in args:
        if isinstance(arg, (list, tuple)):
            nums.extend(arg)
        else:
            nums.append(arg)

    return sorted(nums)
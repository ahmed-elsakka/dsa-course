def loop_twice(arr):
    arr_copy_1 = []
    arr_copy_2 = []

    for i in arr:
        print(i)
        arr_copy_1.append(i)

    for i in arr:
        print(i)
        arr_copy_2.append(i)


input_arr = [1, 2, 3]
loop_twice(input_arr)

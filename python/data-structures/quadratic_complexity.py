def nested_loop_and_count(arr):
    result = []
    counter = 0

    for i in arr:
        for j in arr:
            counter += 1
            result.append(counter)
            print(counter)

    for k in arr:
        print(k)

    return result


input_array = [1, 2, 3]
output = nested_loop_and_count(input_array)
print(output)

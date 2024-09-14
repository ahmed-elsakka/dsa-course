def binary_search(arr, target):
    low, high = 0, len(arr) - 1

    while low <= high:
        mid = (low + high) // 2

        if arr[mid] == target:
            # Target found, return the index
            return mid
        elif arr[mid] < target:
            # Target may be in the right half
            low = mid + 1
        else:
            # Target may be in the left half
            high = mid - 1

    # Target not found in the array
    return -1

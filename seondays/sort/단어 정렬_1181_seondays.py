# 피벗을 균형있게 잡는 것이 중요하다. 한쪽으로 쏠릴 경우 재귀가 깊어지고, 시간도 길어진다. 피벗을 위한 함수를 따로 사용한다.
def median_of_three(arr, start, end):
    mid = (start + end) // 2
    a = arr[start]
    b = arr[mid]
    c = arr[end]
    if a <= b <= c or c <= b <= a:
        return mid
    elif b <= a <= c or c <= a <= b:
        return start
    else:
        return end

# 퀵소트 직접 구현해서 풀이
def quick_sort_inplace(arr, start, end):
    if start < end:
        pivot_index = median_of_three(arr, start, end)
        arr[pivot_index], arr[end] = arr[end], arr[pivot_index]
        pivot = partition(arr, start, end)
        quick_sort_inplace(arr, start, pivot - 1)
        quick_sort_inplace(arr, pivot + 1, end)

def partition(arr, start, end):
    pivot = arr[end]
    index = start

    for j in range(start, end):
        if len(arr[j]) < len(pivot):
            arr[index], arr[j] = arr[j], arr[index]
            index += 1
        elif len(arr[j]) == len(pivot):
            if arr[j] < pivot:
                arr[index], arr[j] = arr[j], arr[index]
                index += 1
    
    arr[end], arr[index] = arr[index], arr[end]
    return index

n = int(input())
words = []

for i in range(n):
    word = input().strip()
    if word not in words:
        words.append(word)

quick_sort_inplace(words, 0, len(words) - 1)

print(*words, sep="\n")
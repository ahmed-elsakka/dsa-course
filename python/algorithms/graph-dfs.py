def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()

    print(start, end=' ')
    visited.add(start)

    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)


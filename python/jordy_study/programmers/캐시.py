cacheSize = 0
cities = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]


def solution(cacheSize, cities):
    result = 0
    cache = []
    for city in cities:
        city = city.upper()
        if city not in cache:
            if cacheSize > 0:
                if len(cache) >= cacheSize:
                    cache.remove(cache[0])
                cache.append(city)
            result += 5
        elif city in cache:
            cache.remove(city)
            cache.append(city)
            result += 1

    return result


print(solution(cacheSize, cities))

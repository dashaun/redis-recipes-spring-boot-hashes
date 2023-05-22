[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

# Redis Recipes with Spring Boot
## Hashes Data Type

Examples, implemented as Spring Cloud Functions, using Spring Data Redis 2.6-M2

## Getting started

1. Pull (6.2.x) latest version of Redis from Docker
    ```bash
    docker pull redis:6.2
    ```
2. Start Redis
    ```bash
    docker run --name redis6.2 -p 6379:6379 -d redis
    ``` 
3. Clone the repository
    ```bash
    git clone git@github.com:LeapAheadWithRedis/redis-whats-new-functions.git
    ```
4. CD into the repository
    ```bash
    cd redis-whats-new-functions
    ```
5. Start the examples
   ```bash
   ./mvnw clean spring-boot:run
   ```
   >Runs the functions locally, using the docker deployed Redis instance

## See Also

[redis-whats-new](https://github.com/redis-recipes-spring-boot-hashes/redis-whats-new)

[slides](https://github.com/redis-recipes-spring-boot-hashes/slides)

## License

Distributed under the MIT License. See `LICENSE` for more information.

[contributors-shield]: https://img.shields.io/github/contributors/redis-recipes-spring-boot-hashes/redis-whats-new-functions.svg?style=for-the-badge
[contributors-url]: https://github.com/redis-recipes-spring-boot-hashes/redis-whats-new-functions/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/redis-recipes-spring-boot-hashes/redis-whats-new-functions.svg?style=for-the-badge
[forks-url]: https://github.com/redis-recipes-spring-boot-hashes/redis-whats-new-functions/network/members
[stars-shield]: https://img.shields.io/github/stars/redis-recipes-spring-boot-hashes/redis-whats-new-functions.svg?style=for-the-badge
[stars-url]: https://github.com/redis-recipes-spring-boot-hashes/redis-whats-new-functions/stargazers
[issues-shield]: https://img.shields.io/github/issues/redis-recipes-spring-boot-hashes/redis-whats-new-functions.svg?style=for-the-badge
[issues-url]: https://github.com/redis-recipes-spring-boot-hashes/redis-whats-new-functions/issues
[license-shield]: https://img.shields.io/github/license/redis-recipes-spring-boot-hashes/redis-whats-new-functions.svg?style=for-the-badge
[license-url]: https://github.com/redis-recipes-spring-boot-hashes/redis-whats-new-functions/blob/master/LICENSE.txt
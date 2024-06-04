package com.hello.api

import kotlinx.coroutines.flow.Flow


interface CreateUserRepo {
    suspend fun createUser(): Flow<Result<UserCreateResponse>>
}
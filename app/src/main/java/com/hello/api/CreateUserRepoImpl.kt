package com.hello.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//class CreateUserRepoImpl(
//    private val api: API_Builder
//) : CreateUserRepo {
//    override suspend fun createUser(): Flow<Result<UserCreateResponse>> {
//        return flow {
//            val userCreateResponse = try {
//                api.createUser(
//                    "Krishna",
//                    "1234",
//                    "shreyansh@gmail.com",
//                    "test address",
//                    "123456",
//                    "12121212"
//                )
//            } catch (e: Exception) {
//                emit(Result.Error(message = e.localizedMessage!!.toString()))
//                return@flow
//            }
//            emit(Result.Success(userCreateResponse))
//        }
//    }
//
//}
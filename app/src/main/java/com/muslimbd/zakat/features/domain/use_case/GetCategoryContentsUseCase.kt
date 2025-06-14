package com.muslimbd.zakat.features.domain.use_case

import com.muslimbd.zakat.core.util.Async
import com.muslimbd.zakat.features.data.remote.model.CategoryContentsDto
import com.muslimbd.zakat.features.domain.repository.ApiRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoryContentsUseCase @Inject constructor(
    private val apiRepo: ApiRepo
) {
    operator fun invoke(id: String): Flow<Async<CategoryContentsDto>> = flow {
        try {
            emit(Async.Loading())

//            val contents = textContentRepo.getContentsByCategory(id)
//            if(contents.isNotEmpty()) {
//                emit(Async.Success(CategoryContentsDto(data = contents.reversed())))
//            }

            val categories = apiRepo.getCategoryContents(id)
            emit(Async.Success(categories.copy(data = categories.data?.filter {
                it.isActive ?: false
            }?.reversed())))

//            textContentRepo.createTextContents(categories.data?.filter { it.isActive ?: false }
//                ?: emptyList())

        } catch (e: HttpException) {
            emit(Async.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Async.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
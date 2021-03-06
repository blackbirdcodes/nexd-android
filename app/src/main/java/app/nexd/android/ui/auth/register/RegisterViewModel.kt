package app.nexd.android.ui.auth.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import app.nexd.android.Preferences
import app.nexd.android.R
import app.nexd.android.api
import app.nexd.android.api.model.RegisterDto
import app.nexd.android.ui.utils.ErrorUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    sealed class Progress {
        object Idle : Progress()
        object Loading : Progress()
        class Error(val message: String) : Progress()
        object Finished : Progress()
    }

    data class RegistrationData(
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String
    )

    val firstName = MutableLiveData("")

    val firstNameError = MutableLiveData(0)

    val lastName = MutableLiveData("")

    val lastNameError = MutableLiveData(0)

    val email = MutableLiveData("")

    val emailError = MutableLiveData(0)

    val password = MutableLiveData("")

    val passwordError = MutableLiveData(0)

    val passwordConfirmation = MutableLiveData("")

    val passwordConfirmationError = MutableLiveData(0)

    val progress = MutableLiveData<Progress>(Progress.Idle)

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

    fun register() {
        var success = true

        if (firstName.value.isNullOrEmpty()) {
            firstNameError.value = R.string.error_message_user_detail_field_missing
            success = false
        }

        if (lastName.value.isNullOrEmpty()) {
            lastNameError.value = R.string.error_message_user_detail_field_missing
            success = false
        }

        if (email.value.isNullOrEmpty()) {
            emailError.value = R.string.error_message_user_detail_field_missing
            success = false
        }

        if (password.value.isNullOrEmpty()) {
            passwordError.value = R.string.error_message_user_detail_field_missing
            success = false
        }

        if (passwordConfirmation.value.isNullOrEmpty()) {
            passwordConfirmationError.value = R.string.error_message_user_detail_field_missing
            success = false
        } else if (password.value != passwordConfirmation.value) {
            passwordError.value = R.string.error_message_registration_password_match
            passwordConfirmationError.value = R.string.error_message_registration_password_match
            success = false
        }

        if (success) {
            progress.value = Progress.Loading
            with(api) {
                authControllerRegister(
                    RegisterDto()
                        .firstName(firstName.value)
                        .lastName(lastName.value)
                        .email(email.value)
                        .password(password.value)
                )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        api.setBearerToken(it.accessToken)
                        with(getApplication<Application>().applicationContext) {
                            Preferences.setToken(this, it.accessToken)
                        }
                        progress.value = Progress.Finished
                    }, {
                        progress.value = Progress.Error(ErrorUtil.parseError(it).firstMessage)
                    })
            }
        }
    }

}
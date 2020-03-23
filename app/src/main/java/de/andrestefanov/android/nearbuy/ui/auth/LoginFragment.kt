package de.andrestefanov.android.nearbuy.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import de.andrestefanov.android.nearbuy.Preferences
import de.andrestefanov.android.nearbuy.R
import de.andrestefanov.android.nearbuy.api
import de.andrestefanov.android.nearbuy.api.AuthenticationApi
import de.andrestefanov.android.nearbuy.api.model.LoginPayload
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.auth_fragment.*
import kotlinx.android.synthetic.main.auth_fragment.button_login
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edittext_password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                login()
            }
            false
        }

        button_login.setOnClickListener {
            with(api) {
                authControllerLogin(
                    LoginPayload()
                        .email(edittext_email.text.toString())
                        .password(edittext_password.text.toString())
                )
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        { loginResponse ->
                            context?.let {
                                Preferences.setToken(it, loginResponse.accessToken)
                                Preferences.setUserId(it, loginResponse.id)
                                api.setBearerToken(loginResponse.accessToken)
                            }

                            findNavController().navigate(R.id.action_loginFragment_to_roleFragment)
                        },
                        {
                            Log.e(LoginFragment::class.simpleName, "Login failed", it)
                        }
                    )
            }
        }
    }
}

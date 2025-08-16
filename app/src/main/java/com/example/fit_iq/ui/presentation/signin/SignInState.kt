package com.example.fit_iq.ui.presentation.signin

import coil.compose.AsyncImagePainter

data class SignInState(
    val isGoogleSignInButtonLoading: Boolean = false,
    val isAnonymousSignInButtonLoading: Boolean = false,
)

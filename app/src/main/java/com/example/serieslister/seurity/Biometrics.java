package com.example.serieslister.seurity;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.serieslister.MainActivity;

import java.util.concurrent.Executor;

public class Biometrics {

    static BiometricPrompt biometricPrompt;
    static BiometricPrompt.PromptInfo promptInfo;

    public static void fingerprintScan(ConstraintLayout constraintLayout, Context context, MainActivity mainActivity) {
        BiometricManager biometricManager = BiometricManager.from(mainActivity);
        switch (biometricManager.canAuthenticate(BiometricManager.Authenticators.DEVICE_CREDENTIAL)) {
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                extracted(context, "BIOMETRIC_ERROR_HW_UNAVAILABLE");
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                extracted(context, "BIOMETRIC_ERROR_NO_HARDWARE");
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                extracted(context, "BIOMETRIC_ERROR_NONE_ENROLLED");
                break;
            case BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED:
                extracted(context, "BIOMETRIC_ERROR_UNSUPPORTED");
                break;
            case BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED:
                extracted(context, "BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED");
                break;
            case BiometricManager.BIOMETRIC_STATUS_UNKNOWN:
                extracted(context, "BIOMETRIC_STATUS_UNKNOWN");
                break;
        }

        Executor executor = ContextCompat.getMainExecutor(mainActivity);
        biometricPrompt = new BiometricPrompt(mainActivity, executor, new BiometricPrompt.AuthenticationCallback(){

            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                Toast.makeText(context, "You suck!", Toast.LENGTH_LONG);
            }
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                //super.onAuthenticationSucceeded(result);
                Toast.makeText(context, "May thee be happy", Toast.LENGTH_LONG);
                constraintLayout.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAuthenticationFailed() {
                Toast.makeText(context, "You suck!", Toast.LENGTH_LONG);
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("FingerPrint")
                .setDescription("Put your cock on the fingerprint scanner")
                .setAllowedAuthenticators(BiometricManager.Authenticators.DEVICE_CREDENTIAL)
                .build();

        biometricPrompt.authenticate(promptInfo);;
    }

    private static void extracted(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}

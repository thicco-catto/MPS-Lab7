package org.mps.authentication;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class UserRegistraticonTest {

    //credenciales guardados
    @Test
    void shouldRegisterUserIfTheValuesAreCorrect() {
        Date date = Mockito.mock(Date.class);

        PasswordString passwordString = Mockito.mock(PasswordString.class);

        CredentialStore credentialStore = Mockito.mock(CredentialStore.class);

        CredentialValidator credentialValidator = Mockito.mock(CredentialValidator.class);
        Mockito.when(credentialValidator.validate()).thenReturn(CredentialValidator.ValidationStatus.VALIDATION_OK);

        var user = new UserRegistration();
        user.register(date, passwordString, credentialStore, credentialValidator);

        Mockito.verify(credentialStore, Mockito.times(1)).register(date, passwordString);

    }


}



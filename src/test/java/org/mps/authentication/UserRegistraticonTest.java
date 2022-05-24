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

    @Test
    public void ShouldNotRegisterUserIfDateValidateFails(){
        var date = Mockito.mock(Date.class);
        var password = Mockito.mock(PasswordString.class);
        var credentialStore = Mockito.mock(CredentialStore.class);

        var credentialValidator = Mockito.mock(CredentialValidator.class);
        Mockito.when(credentialValidator.validate()).thenReturn(CredentialValidator.ValidationStatus.BIRTHDAY_INVALID);

        var userRegistration = new UserRegistration();
        userRegistration.register(date, password, credentialStore, credentialValidator);

        Mockito.verify(credentialStore, times(0)).register(date, password);
    }
}

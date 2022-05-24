package org.mps.authentication;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class UserRegistraticonTest {
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

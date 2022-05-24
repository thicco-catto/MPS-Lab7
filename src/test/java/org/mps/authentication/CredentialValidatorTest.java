package org.mps.authentication;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CredentialValidatorTest {
    @Test
    public void ShouldReturnValidationOkIfValidationIsCorrect() {
        Date date = Mockito.mock(Date.class);
        Mockito.when(date.validate()).thenReturn(true);
        PasswordString passwordString = Mockito.mock(PasswordString.class);
        Mockito.when(passwordString.validate()).thenReturn(true);
        CredentialStore credentialStore = Mockito.mock(CredentialStore.class);
        Mockito.when(credentialStore.credentialExists(date, passwordString)).thenReturn(true);

        var credentialValidator = new CredentialValidator(date, passwordString, credentialStore);

        assertEquals(CredentialValidator.ValidationStatus.VALIDATION_OK, credentialValidator.validate());


    }

    @Test
    public void ShouldReturnBirthdayInvalidIdDateIsInvalid() {
        Date date = Mockito.mock(Date.class);
        Mockito.when(date.validate()).thenReturn(false);
        PasswordString passwordString = Mockito.mock(PasswordString.class);
        Mockito.when(passwordString.validate()).thenReturn(true);
        CredentialStore credentialStore = Mockito.mock(CredentialStore.class);
        Mockito.when(credentialStore.credentialExists(date, passwordString)).thenReturn(true);

        var credentialValidator = new CredentialValidator(date, passwordString, credentialStore);

        assertEquals(CredentialValidator.ValidationStatus.BIRTHDAY_INVALID, credentialValidator.validate());


    }

    @Test
    public void ShouldReturnPasswordInvalidIfPasswordIsInvalid() {

    }

    @Test
    public void ShouldReturnCredentialInvalidIfCredentialDoesNotExist() {

    }
}

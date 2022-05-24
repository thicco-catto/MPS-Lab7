# Pruebas de Integración Top-Down - Laboratorio 7
Realizadas por Cristobal Martin y Sergio Morejón

## Test Realizados
### UserRegistrationTest
- shouldRegisterUserIfTheValuesAreCorrect -> Comprueba que se registra el usuario si los valores son correctos
- ShouldNotRegisterUserIfDateValidateFails ->  Comprueba que no se registra el usuario si los valores son invalidos

### CredentialValidatorTest
- ShouldReturnValidationOkIfValidationIsCorrect -> Comprueba que la validación ha sido correcta
- ShouldReturnBirthdayInvalidIdDateIsInvalid -> Comprueba que la validación ha sido incorrecta debido al cumpleaños
- ShouldReturnPasswordInvalidIfPasswordIsInvalid-> Comprueba que la validación ha sido incorrecta debido a la contraseña
- ShouldReturnCredentialInvalidIfCredentialDoesNotExist
->Comprueba que la validación ha sido incorrecta debido a que el credencial no existe

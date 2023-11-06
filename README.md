# Fiszkord
Spring backend.

### Endpointy
---
> POST /api/auth/register

Rejestracja. Wymagane body:
- firstname: String
- lastname: String
- email: String
- password: String
- role: enum(USER, MANAGER, ADMIN)

Zwraca:
- access_token: String
- refresh_token: String

---

> GET /api/check

Zwraca wiadomość zalogowanemu użytkownikowi.

---

> POST /api/auth/login

Logowanie. Wymagane body:
- email: String
- password: String

Zwraca:
- access_token: String
- refresh_token: String

---

> PATCH /api/users

Zmiana hasła. Wymagane body:
- currentPassword: String
- newPassword: String
- confirmationPassword: String

---

> POST /api/auth/refresh-token

Zmiana tokenu. Wymagany *refresh_token* w nagłówku Authorization. Zwraca: 
- access_token: String
- refresh_token: String

---

> GET /api/auth/logout

Wylogowanie.

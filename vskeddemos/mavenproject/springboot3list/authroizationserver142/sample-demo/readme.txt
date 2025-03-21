

update spring boot to 3.4.3
update spring authorization server to 1.4.2


at first we start
demo-authorizationserver
port 9000

then we start
messages-resource
port 8090

last start
demo-client
port 8080

http://127.0.0.1:8080/index

use your browser open link
http://127.0.0.1:9000/oauth2/authorize?client_id=messaging-client&response_type=code&scope=message.read&redirect_uri=http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc

then browser redirect to
/login
login page

input user name user1
and password password

checked the check box
click submit button

watch the authorization server application console you can see some text like
Redirecting to http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc?code=ISdQR4TwIa3koT-whD0N7JB9B7ejUThKoY3IYsUePX3Mrr-mceDBf0__5NG6ilfVt55OZW3OX7h3B97V-0yaXK_GS0lStGg4xZHuU0Qv8kJdvLu4MQ0idUJSluWVuLz0&state=xhy2PffENW0o69_Oy8c5e2wFU3kTzaA6VwsX40rORjE%3D

use this code in url for next request
ISdQR4TwIa3koT-whD0N7JB9B7ejUThKoY3IYsUePX3Mrr-mceDBf0__5NG6ilfVt55OZW3OX7h3B97V-0yaXK_GS0lStGg4xZHuU0Qv8kJdvLu4MQ0idUJSluWVuLz0

use postman or Apifox tool send a post request

application/x-www-form-urlencoded
body parameter is

http://127.0.0.1:9000/oauth2/token
grant_type authorization_code
redirect_uri http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc
code

you can get a token like this

{
    "access_token": "eyJraWQiOiIwM2FlMjllOC04NzJlLTQ3N2EtOWFhMi04MjViMGQyM2ZiZjMiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImF1ZCI6Im1lc3NhZ2luZy1jbGllbnQiLCJuYmYiOjE3NDI1MzgzMTIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiXSwiaXNzIjoiaHR0cDovLzEyNy4wLjAuMTo5MDAwIiwiZXhwIjoxNzQyNTM4NjEyLCJpYXQiOjE3NDI1MzgzMTIsImp0aSI6ImEzZjliOWJjLWU0NmQtNDdiOC04YzkxLWM1ZDNhMDFiNmIyZSJ9.dViVLcX_SmUcZxmS7v6jnLpB4BHR1n9_07s_i1VSP8pxFJEgRXzhbjBdeV0ak5YAeu6y210K_VfoD25bhCBEkFdoiIPH-zETzgAyxsUsvIV7XgAiggPQ5Ca8lrqQtB0-Lik6x9WXWRe4zd-7Ktop8-aZsU3W9CnWoHzI9YXFFtw1DbfdH7OKu3A4ZzqTnZIdATdMFXh0D7F1KXJG04OWyvCPzDtetXmvdWN3ASFiRye5tTW5RvNZgAHI5CZaWohFmLmOpB700Ldm5m2F6Y_3AcATMK0NbKLjl9y-LCrL2dmnzHIXXIaGwdy1ZGdIVqQ-Z_4AlErA35gz2QU6wnixQA",
    "refresh_token": "urejo3ze_qM_FzrfD8QYlKroJPsOiPPm0fwPGHALj11YC2Rh1CbDkog2HB8U-UhWNdHXnETFOWzuoD51NblGdXAYyLjyM0IhflaLa0PhiUeLVROk4gSH4fuTA45XCWPJ",
    "scope": "openid profile",
    "id_token": "eyJraWQiOiIwM2FlMjllOC04NzJlLTQ3N2EtOWFhMi04MjViMGQyM2ZiZjMiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImF1ZCI6Im1lc3NhZ2luZy1jbGllbnQiLCJhenAiOiJtZXNzYWdpbmctY2xpZW50IiwiYXV0aF90aW1lIjoxNzQyNTM4MjM4LCJpc3MiOiJodHRwOi8vMTI3LjAuMC4xOjkwMDAiLCJleHAiOjE3NDI1NDAxMTIsImlhdCI6MTc0MjUzODMxMiwibm9uY2UiOiJ1Z2habFYzQ3lSd2NlMUJydU0wOG5fbEVRdHo5d2NkMzAzSFdvaEtlaVNJIiwianRpIjoiNjliOGZhZjktNjQwYS00YzdmLWJkZDktNmFmMGE0NjUzNDFkIiwic2lkIjoiOHpMZEVTLWJqUVQ2LVJBYk91Skw0QjFHUTR2TFBjOTB3dk5oSzN4UTBxayJ9.jgmgmVMejGTUZcscKSDzQ7hBJ5BHtXWLMFQyiUyzj3INm1DbQKglHirwSeSl-cLtne6SpiyI7AD3izGVBzXSnVoUhM7gXl9KsRrnMtC4DOQr9iBjlW1i53GosKQRcndr34sRFXTphhIyGU7ewYMrp_3jUdyeKc9SCJ_LiDxtxO_O7J3jwFO0iKZLu-Ty5ExS7EppGz__8gdGsouNXVWNu929KTTtY-ooOcT6peZiV5tIB59ecOLQPtP33BHe7szacCwu7kpG9-Ayv7auZDVGwsjWFAxesicnhCx8bX8F5CFCUKA9vULyAIZGWYz1F0wD7jILAcNKkL00gx7uAwojeQ",
    "token_type": "Bearer",
    "expires_in": 300
}


you can decode access_token use
https://www.box3.cn/tools/jwt.html

refresh token

use postman or Apifox tool send a post request

application/x-www-form-urlencoded
body parameter is

http://127.0.0.1:9000/oauth2/token
grant_type refresh_token
refresh_token


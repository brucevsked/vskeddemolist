# coding:utf8
import web
import requests

urls=(
'/hello','GetHello',
'/setHello','SetHello'
)

class GetHello:

    def GET(self):
        i=web.input();
        par1=i.get("a")
        print(par1)
        return "gethello"+ par1


class SetHello:

    def GET(self):
        i=web.input();
        par1=i.get("a") #�����������Բ���д���
        print(par1)
        return "sethello"+ par1

if __name__ == "__main__":
    app=web.application(urls,globals())
    app.run()

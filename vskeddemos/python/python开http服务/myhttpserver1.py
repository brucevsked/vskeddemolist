import web
import requests
import json


urls = (
    '/decode', 'Dec',
    '/ver', 'Ver'
)

def response_wrapper(func):
    def wrap_func(self):
        try:
            func(self)
        except Exception as e :
            code = e.code if hasattr(e, "code") else 1002
            print (e)
            message = e.message if e.message else str(e)
            response = {"code": code,
                        "message": message}
            if hasattr(e, "data") and e.data:
                response["data"] = e.data
            return json.dumps(response)
    return wrap_func

class CPException(Exception):

    def __init__(self, code, message, data=None):
        Exception.__init__(self)
        self.code = code
        self.message = message
        self.data = data

class Dec:

    @response_wrapper
    def POST(self):
        i = web.input()
        ft = i.get("font")
        st = i.get("str")
        print (i)
        if not ft or not st:
            raise CPException(1001, u"参数错误")
        raise CPException(200, u"成功")

class Ver:
    @response_wrapper
    def POST(self):
        raise CPException(200, u"成功")


if __name__ == "__main__":

    app = web.application(urls, globals())
    app.run()


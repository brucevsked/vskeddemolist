# 先运行下面这条命令安装依赖包
# pip install flask pyautogui
from flask import Flask, request, jsonify
import pyautogui
import time
import logging

# 设置日志记录
logging.basicConfig(level=logging.DEBUG)
logger = logging.getLogger(__name__)

app = Flask(__name__)


def simulate_key(key_sequence):
    """
    模拟键盘按键 (仅支持Windows)
    支持单个按键或多个按键序列，按键之间有间隔
    """
    logger.debug(f"尝试按下按键: {key_sequence}")

    # 添加一个小延迟以确保焦点稳定
    time.sleep(0.1)

    try:
        # 处理按键序列（可以是单个字符或多个字符）
        for i, char in enumerate(key_sequence):
            logger.debug(f"按下第{i+1}个字符: {char}")
            pyautogui.press(char.lower())
            # 在按键之间添加间隔（除了最后一个字符）
            if i < len(key_sequence) - 1:
                time.sleep(0.2)  # 200ms间隔

        logger.debug("按键模拟完成")
        return True
    except Exception as e:
        logger.error(f"按键模拟出错: {str(e)}")
        raise


@app.route('/press', methods=['GET', 'POST'])
def press_key():
    try:
        # 获取请求参数
        if request.method == 'GET':
            key = request.args.get('key')
            logger.debug(f"收到GET请求，参数key={key}")
        else:  # POST
            key = request.json.get('key') if request.is_json else request.form.get('key')
            logger.debug(f"收到POST请求，参数key={key}")

        if not key:
            logger.warning("缺少key参数")
            return jsonify({"code": 1001, "message": "参数错误：请提供key参数"}), 400

        try:
            success = simulate_key(key)
            if success:
                return jsonify({"code": 200, "message": f"成功按下按键: {key}"})
            else:
                return jsonify({"code": 1004, "message": "按键模拟失败"}), 500
        except Exception as e:
            logger.error(f"按键模拟异常: {str(e)}")
            return jsonify({"code": 1003, "message": f"按键模拟失败: {str(e)}"}), 500

    except Exception as e:
        logger.error(f"请求处理异常: {str(e)}")
        return jsonify({"code": 1002, "message": str(e)}), 500


@app.route('/', methods=['GET'])
def index():
    return '''
    <h1>远程按键控制服务</h1>
    <p>使用方法:</p>
    <ul>
        <li>GET请求: /press?key=按键名称</li>
        <li>示例（单个按键）: <a href="/press?key=a">/press?key=a</a></li>
        <li>示例（多个按键）: <a href="/press?key=abcdefg">/press?key=abcdefg</a></li>
    </ul>
    '''


if __name__ == "__main__":
    # 在启动时添加pyautogui的必要设置
    pyautogui.FAILSAFE = True
    pyautogui.PAUSE = 0.1

    # 显示当前屏幕分辨率
    screen_size = pyautogui.size()
    logger.info(f"屏幕分辨率: {screen_size}")

    app.run(host='0.0.0.0', port=8080, debug=False)

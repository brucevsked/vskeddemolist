#include <windows.h>

LRESULT CALLBACK WndProc( HWND, UINT, WPARAM, LPARAM ) ;        //声明用来处理消息的函数

int WINAPI WinMain( HINSTANCE hInstance, HINSTANCE hPrevInstance, PSTR szCmdLine, int iCmdShow )
{
    static TCHAR szAppName[] = TEXT("我的第一个窗口") ;
    HWND hwnd ;
    MSG msg ;
    WNDCLASS wndclass ;        //声明一个窗口类对象

    //以下为窗口类对象wndclass的属性
    wndclass.style = CS_HREDRAW | CS_VREDRAW ;                         //窗口样式
    wndclass.lpszClassName = szAppName ;                               //窗口类名
    wndclass.lpszMenuName = NULL ;                                     //窗口菜单:无
    wndclass.hbrBackground = (HBRUSH) GetStockObject(WHITE_BRUSH) ;    //窗口背景颜色
    wndclass.lpfnWndProc = WndProc ;                                   //窗口处理函数
    wndclass.cbWndExtra = 0 ;                                          //窗口实例扩展:无
    wndclass.cbClsExtra = 0 ;                                          //窗口类扩展:无
    wndclass.hInstance = hInstance ;                                   //窗口实例句柄
    wndclass.hIcon = LoadIcon( NULL, IDI_APPLICATION ) ;               //窗口最小化图标:使用缺省图标
    wndclass.hCursor = LoadCursor( NULL, IDC_ARROW ) ;                 //窗口采用箭头光标

    if( !RegisterClass( &wndclass ) )
    {    //注册窗口类, 如果注册失败弹出错误提示
        MessageBox( NULL, TEXT("窗口注册失败!"), TEXT("错误"), MB_OK | MB_ICONERROR ) ;
        return 0 ;
    }

    hwnd = CreateWindow(                   //创建窗口
                szAppName,                 //窗口类名
                TEXT("我的窗口a1"),           //窗口标题
                WS_OVERLAPPEDWINDOW,       //窗口的风格
                CW_USEDEFAULT,             //窗口初始显示位置x:使用缺省值
                CW_USEDEFAULT,             //窗口初始显示位置y:使用缺省值
                CW_USEDEFAULT,             //窗口的宽度:使用缺省值
                CW_USEDEFAULT,             //窗口的高度:使用缺省值
                NULL,                      //父窗口:无
                NULL,                      //子菜单:无
                hInstance,                 //该窗口应用程序的实例句柄
                NULL                       //
            ) ;

    ShowWindow( hwnd, iCmdShow ) ;        //显示窗口
    UpdateWindow( hwnd ) ;                //更新窗口

    while( GetMessage( &msg, NULL, 0, 0 ) )        //从消息队列中获取消息
    {
        TranslateMessage( &msg ) ;                 //将虚拟键消息转换为字符消息
        DispatchMessage( &msg ) ;                  //分发到回调函数(过程函数)
    }
    return msg.wParam ;
}

LRESULT CALLBACK WndProc( HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam )
{
    HDC hdc ;                //设备环境句柄
    PAINTSTRUCT ps ;         //绘制结构
    RECT rect;               //矩形结构

    switch( message )        //处理得到的消息
    {
    case WM_CREATE:          //窗口创建完成时发来的消息
        MessageBox( hwnd, TEXT("窗口已创建完成!"), TEXT("我的窗口"), MB_OK | MB_ICONINFORMATION ) ;
        return 0;

    case WM_PAINT:           //处理窗口区域无效时发来的消息
        hdc = BeginPaint( hwnd, &ps ) ;
        GetClientRect( hwnd, &rect ) ;
        DrawText( hdc, TEXT( "Hello, 这是我自己的窗口!" ), -1, &rect, DT_SINGLELINE | DT_CENTER | DT_VCENTER ) ;
        EndPaint( hwnd, &ps ) ;
        return 0 ;

    case WM_LBUTTONDOWN:     //处理鼠标左键被按下的消息
        MessageBox( hwnd, TEXT("鼠标左键被按下。"), TEXT("单击"), MB_OK | MB_ICONINFORMATION ) ;
        return 0;

    case WM_DESTROY:         //处理窗口关闭时的消息
        MessageBox( hwnd, TEXT("关闭程序!"), TEXT("结束"), MB_OK | MB_ICONINFORMATION ) ;
        PostQuitMessage( 0 ) ;
        return 0;
    }
    return DefWindowProc( hwnd, message, wParam, lParam ) ;        //DefWindowProc处理我们自定义的消息处理函数没有处理到的消息
}

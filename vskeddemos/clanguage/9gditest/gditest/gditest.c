#include <windows.h>
LRESULT CALLBACK WndProc (HWND, UINT, WPARAM, LPARAM) ;
int WINAPI WinMain (HINSTANCE hInstance, HINSTANCE hPrevInstance,
                    PSTR szCmdLine, int iCmdShow)
{
    static TCHAR szAppName[] = TEXT ("HelloWin") ;
    HWND hwnd ;
    MSG msg ;
    WNDCLASS wndclass ;
    wndclass.style = CS_HREDRAW | CS_VREDRAW ;
    wndclass.lpfnWndProc = WndProc ;
    wndclass.cbClsExtra = 0 ;
    wndclass.cbWndExtra = 0 ;
    wndclass.hInstance = hInstance ;
    wndclass.hIcon = LoadIcon (NULL, IDI_APPLICATION) ;
    wndclass.hCursor = LoadCursor (NULL, IDC_ARROW) ;
    wndclass.hbrBackground = (HBRUSH) GetStockObject (WHITE_BRUSH) ;
    wndclass.lpszMenuName = NULL ;
    wndclass.lpszClassName = szAppName ;
    if (!RegisterClass (&wndclass))
    {
        MessageBox ( NULL, TEXT ("This program requires Windows NT!"),
                     szAppName, MB_ICONERROR) ;
        return 0 ;
    }
    hwnd = CreateWindow( szAppName, // window class name
                         TEXT ("my create win title"), // window caption
                         WS_OVERLAPPEDWINDOW, // window style
                         CW_USEDEFAULT, // initial x position
                         CW_USEDEFAULT, // initial y position
                         CW_USEDEFAULT, // initial x size
                         CW_USEDEFAULT, // initial y size
                         NULL, // parent window handle
                         NULL, // window menu handle
                         hInstance, // program instance handle
                         NULL) ; // creation parameters

    ShowWindow (hwnd, iCmdShow) ;
    UpdateWindow (hwnd) ;

    while (GetMessage (&msg, NULL, 0, 0))
    {
        TranslateMessage (&msg) ;
        DispatchMessage (&msg) ;
    }
    return msg.wParam ;
}
LRESULT CALLBACK WndProc (HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    HDC hdc ;
    PAINTSTRUCT ps ;
    //定义两个画刷,请定义为静态变量
    static HBRUSH hSolidBrush;
    static HBRUSH hHatchBrush;
    switch (message)
    {
    case WM_CREATE:
        //创建蓝色实心画刷，保存句柄到 hSolidBrush 变量
        hSolidBrush = CreateSolidBrush(RGB(0, 0, 255));
        //创建绿色交叉阴影画刷，保存句柄到 hHatchBrush 变量
        hHatchBrush = CreateHatchBrush(HS_DIAGCROSS,RGB(0,255,0));
        break;
    case WM_PAINT:
        hdc = BeginPaint(hwnd, &ps);
        //选入蓝色实心画刷到设备环境
        SelectObject(hdc, hSolidBrush);
        Rectangle(hdc, 20, 20, 200, 100); //绘制矩形
        //选入绿色交叉画刷到设备环境
        SelectObject(hdc, hHatchBrush);
        Ellipse(hdc,220,20,400,200); //绘制椭圆1
        SelectObject(hdc, hSolidBrush);
        Ellipse(hdc,10,150,100,200); //绘制椭圆2
        EndPaint(hwnd, &ps);
        break;

    case WM_DESTROY:
        //请做好善后工作,处理 WM_DESTROY 消息时删除之前我们创建的一切GDI对象。
        DeleteObject(hSolidBrush);
        DeleteObject(hHatchBrush);
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hwnd, message, wParam, lParam);
    }
}

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
    //����������ˢ,�붨��Ϊ��̬����
    static HBRUSH hSolidBrush;
    static HBRUSH hHatchBrush;
    switch (message)
    {
    case WM_CREATE:
        //������ɫʵ�Ļ�ˢ���������� hSolidBrush ����
        hSolidBrush = CreateSolidBrush(RGB(0, 0, 255));
        //������ɫ������Ӱ��ˢ���������� hHatchBrush ����
        hHatchBrush = CreateHatchBrush(HS_DIAGCROSS,RGB(0,255,0));
        break;
    case WM_PAINT:
        hdc = BeginPaint(hwnd, &ps);
        //ѡ����ɫʵ�Ļ�ˢ���豸����
        SelectObject(hdc, hSolidBrush);
        Rectangle(hdc, 20, 20, 200, 100); //���ƾ���
        //ѡ����ɫ���滭ˢ���豸����
        SelectObject(hdc, hHatchBrush);
        Ellipse(hdc,220,20,400,200); //������Բ1
        SelectObject(hdc, hSolidBrush);
        Ellipse(hdc,10,150,100,200); //������Բ2
        EndPaint(hwnd, &ps);
        break;

    case WM_DESTROY:
        //�������ƺ���,���� WM_DESTROY ��Ϣʱɾ��֮ǰ���Ǵ�����һ��GDI����
        DeleteObject(hSolidBrush);
        DeleteObject(hHatchBrush);
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hwnd, message, wParam, lParam);
    }
}

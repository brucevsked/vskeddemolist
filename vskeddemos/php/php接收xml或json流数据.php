<?

$input = file_get_contents("php://input"); //接收POST数据
$xml = simplexml_load_string($input); //提取POST数据为simplexml对象
var_dump($xml);

?>
<?

$input = file_get_contents("php://input"); //����POST����
$xml = simplexml_load_string($input); //��ȡPOST����Ϊsimplexml����
var_dump($xml);

?>
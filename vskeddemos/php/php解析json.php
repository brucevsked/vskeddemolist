<?

$jsonStr='{"ID":"987556","NAME":"lostweek","MOBILE":"13899999999","ROLE":"1","STUNUM":"S17758","CLASSID":"C9611","GRADEID":"G1181","SCHOOLID":"S985","COUNTYID":"CN","CITYID":"JN"}';
$stuArra = json_decode($jsonStr, true);

$stuArrb = json_decode($jsonStr);

$myIda=$stuArra['ID'];
$myIdb=$stuArrb->ID;

echo $myIda .'<br>';
echo $myIdb .'<br>';

$jsonStr='[{"ID":"98888","NAME":"lostweek","MOBILE":"13899999999","ROLE":"1","STUNUM":"S17758","CLASSID":"C9611","GRADEID":"G1181","SCHOOLID":"S985","COUNTYID":"CN","CITYID":"JN"}]';
$stuArrb = json_decode($jsonStr);
$myIdb=$stuArrb[0]->ID;

echo $myIdb .'<br>';

?>
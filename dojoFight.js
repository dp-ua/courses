var pointWhereIWas = [];

function isNotContainPointinList(point,list){
  return([...list].filter((e) => (e.x===point.x && e.y===point.y)).length===0);
}
function getAvailablePointAroundForMove(scanner) {
    var dx=0;
    var dy=0;
    var points =[];
    var me = scanner.getMe();
    var meXY = {x: me.getX(), y: me.getY()};
    for (var i=0;i<4;i++) {
        switch (i) {
        case 0 : dx=1;
                 dy=0;
                 break;
        case 1 : dx=-1;
                 dy=0;
                 break;
        case 2 : dx=0;
                 dy=1;
                 break;
        case 3 : dx=0;
                 dy=-1;
                 break;
        }
        var tempX = meXY.x+dx;
        var tempY = meXY.y+dy
        if (!scanner.isBarrierAt(tempX,tempY)) {
            console.log(tempX+':' + tempY + ' ��� �������');
            points.push({x:tempX,y:tempY});
            
        }
        else {
            if (!scanner.isBarrierAt(tempX+dx,tempY+dy)) {
                console.log( (tempX+dx) + ':' + (tempY+dy) + ' ������� ��������');
                points.push({x:tempX,y:tempY,jump:true});
            }
         }
    }
    return points;
}
function getRandomFromList(list) {
  var rnd=Math.floor( Math.random() * list.length);
  return list[rnd];
}
function getNeverRunPoints(iWas, available) {
    var points = [];
    available.forEach( (e) => {
        if (isNotContainPointinList(e,iWas)) 
        points.push(e);
        })
    return points;
}
function getGoldTargetsForMove(scanner) {
    var gold = scanner.findAll("GOLD");
    if (gold.length>0) return gold.filter((e) => { return {x:e.getX(),y:e.getY()} });
    else return [];
}
function getExitTargetsForMove(scanner) {
    var exit = scanner.findAll("EXIT");
    if (exit.length>0) return exit.filter((e) => { return {x:e.getX(),y:e.getY()} });
    else return [];
}
function range (p1,p2) {
  return Math.sqrt(Math.pow((p1.x-p2.x),2) + Math.pow((p1.y-p2.y),2));
}
function getMoreClosePointForTarget(points, target){
  var result = points[0];
  [...points].forEach((point) => { result = range(point,target) < range(result,target) ? point : result;  });
  return result;
}
function getDirection(current,target) {
  var dx = target.x-current.x;
  var dy = current.y-target.y;
  if (dx!==0) return dx>0? 'RIGHT' : 'LEFT';
  else return dy>0? 'DOWN' : 'UP';
}

function program(robot) {
    try {
    console.log('----------------------------- ������ ��������');
    var scanner = robot.getScanner();
    var me = scanner.getMe();
    meXY = {x:me.getX(),y:me.getY()};
    console.log("� ���: ");
    console.log( meXY);
    
    if (isNotContainPointinList(meXY,pointWhereIWas)) pointWhereIWas.push(meXY);
    var pointsToMoveAllAroundMe = getAvailablePointAroundForMove(scanner);
    var neverRunPointsAroundMe = getNeverRunPoints(pointWhereIWas,pointsToMoveAllAroundMe);
    var needTarget = getGoldTargetsForMove(scanner);
    var exitTarget = getExitTargetsForMove(scanner);
    
    var pointsToUse = [...neverRunPointsAroundMe].length > 0 ? neverRunPointsAroundMe : pointsToMoveAllAroundMe;
    var target = ([...needTarget].length > 0 ? needTarget : exitTarget)[0];
    console.log('�����, ���� �� ����� �����:')
    console.log(pointsToUse);
    
    var go = getMoreClosePointForTarget(pointsToUse,target);
    console.log("��������� ��������� �����: ");
    console.log(go);
    
    var direction = getDirection(meXY,go);

    (go.jump) ? robot.jump(direction) : robot.go(direction);
    if (isNotContainPointinList(go,pointWhereIWas)) pointWhereIWas.push(go);
    console.log('----------------------------- ����� ��������');
    console.log('/////////////////////////////////////////////');
    } catch (err) {
        robot.log('������' + err);
        
    }
}

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>暗黑破坏神2 人物攻击命中率(准确率)在线计算器Peterpaulruben's D2X/1.11 AR Calculator</title>
<script language="Javascript">

var debug = false;
function do_populate() {
  /*only called on the page load */

  for (var i = 1; i <= 99; i++) {
    document.AR.alvl.options[i-1] = new Option(i,i);
    document.AR.dlvl.options[i-1] = new Option(i,i);
  }
  document.AR.dlvl.options[99] = new Option ('110 (UberDiablo)',110);
  do_ar_calc();
}

function do_ar_calc() {
  var f = document.AR; 
  if (f.dex.value && f.alvl.value && f.dlvl.value && f.dr.value && f.plusARint.value && f.plusARpercent.value) {
    var class_bonus = f.cclass.value * 1;
    var alvl = parseInt(f.alvl.value,10);
    var dex = parseInt(f.dex.value,10);
    var plusint = parseInt(f.plusARint.value,10);
    var pluspercent = parseInt(f.plusARpercent.value,10);

    var base_ar = (dex * 5) -(35 - class_bonus);
    base_ar = base_ar + plusint;
    var total_ar = base_ar * (1 + pluspercent/100);
    f.final_ar.value = Math.floor(total_ar);
    do_hit_chance_calc();
  }
  return;
}

function do_hit_chance_calc() {
  var f = document.AR; 
  var alvl = parseInt(f.alvl.value,10);
  var ar = parseInt(f.final_ar.value,10);
  var dlvl = parseInt(f.dlvl.value,10);
  var dr = parseInt(f.dr.value,10);
  var base_hit = 100 * ar / (ar + dr) * 2 * alvl / (alvl + dlvl);
  base_hit = (base_hit > 95) ? 95 : base_hit;
  base_hit = (base_hit < 5) ? 5 : base_hit;  
  f.hit_chance.value = Math.floor(base_hit);
  var block = parseInt(f.block_percent.value,10);
  var chance_after_blocking =  (block <= 0) ? base_hit : Math.floor(base_hit * ((100 - block) /100));
  if (debug) {alert(chance_after_blocking)}
  f.actual_chance.value = chance_after_blocking;
  return;
}
</script>


</head>
<!-- Background white, links blue (unvisited), navy (visited), red (active) -->
<body bgcolor="#FFFFFF" text="#000000" link="#0000FF" vlink="#000080" alink="#FF0000" onLoad="do_populate();">

<font size="5"><b><center>Peterpaulruben's D2X/1.11 AR Calculator</b></font></center><br>

<form name='AR' action="">
<center><table width="50%" border="0" cellspacing="0" cellpadding="0">
<tr>
  <td align="right">Character Class(角色职业)&nbsp;&nbsp;  </td>
  <td align="left"><select name='cclass'>
    <option value=5>Amazon
    <option value=15>Assassin
    <option value=20>Barbarian
    <option value=5>Druid
    <option value=-10>Necromancer
    <option value=20>Paladin
    <option value=-15>Sorceress
  </td>
</tr>
<tr>
  <td align="right">Attacker's Level(角色等级)&nbsp;&nbsp;</td>
  <td align="left"><select name="alvl" onChange="do_ar_calc();"></td>
</tr>
<tr>
  <td align="right">Dexterity(角色敏捷)&nbsp;&nbsp;</td>
  <td align="left"><input type='text' name="dex" value="20" onChange="do_ar_calc();"></td>
</tr>
<tr>
  <td align="right">Total Plus to AR (integer)(累计AR值)&nbsp;&nbsp;</td>
  <td align="left"><input type='text' name="plusARint" value="0" onChange="do_ar_calc();"></td>
</tr>
<tr>
  <td align="right">Total Plus to AR (percent)(累计AR加成百分比)&nbsp;&nbsp;</td>
  <td align="left"><input type='text' name="plusARpercent" value="0" onChange="do_ar_calc();"></td>
</tr>
<tr>
<tr>
  <td align="right">Defender's Level(目标等级)&nbsp;&nbsp;</td>
  <td align="left"><select name="dlvl" onChange="do_ar_calc();"></td>
</tr>
<tr>
  <td align="right">Defender's Defense Rating (目标防御值)&nbsp;&nbsp;</td>
  <td align="left"><input type='text' name="dr" value="0" onChange="do_ar_calc();"></td>
</tr>
<tr>
  <td align="right">&nbsp;&nbsp;</td>
</tr>
<tr>
  <td align="right">Final Attack Rating(最终攻击准确率) &nbsp;&nbsp;</td>
  <td align="left"><input type='text' name="final_ar" readonly></td>
</tr>
<tr>
  <td align="right">% Chance to Hit (击中几率)&nbsp;&nbsp;</td>
  <td align="left"><input type='text' name="hit_chance" readonly></td>
</tr>


</table>
<br><br><br>

<br>
<br><br><br>
</center>
</body>
</html>
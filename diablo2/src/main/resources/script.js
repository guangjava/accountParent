/**
 * 
 */

function swap_content( span ) {
    displayType = ( document.getElementById( span ).style.display == 'none' ) ? 'block' : 'none';
    document.getElementById( span ).style.display = displayType;
}

  var LANG = "english";


var SKILL_STANDARD;
var SKILL_AMA_0;
var SKILL_AMA_1;
var SKILL_AMA_2;
var SKILL_AMA_3;
var SKILL_AMA_4;
var SKILL_BABA_0;
var SKILL_BABA_1;
var SKILL_BABA_2;
var SKILL_BABA_3;
var SKILL_BABA_4;
var SKILL_PALA_0;
var SKILL_PALA_1;
var SKILL_PALA_2;
var SKILL_SORC_0;
var SKILL_SORC_1;
var SKILL_DRU_0;
var SKILL_DRU_1;
var SKILL_DRU_2;
var SKILL_DRU_3;
var SKILL_ASSA_0;
var SKILL_ASSA_1;
var SKILL_ASSA_2;
var SKILL_ASSA_3;
var SKILL_ACT2_0;
var GUI_BABA_1H;
var GUI_BABA_2H;
var GUI_ASSA_1H;
var GUI_ASSA_2H;
var DYN_WEAPON_1;
var DYN_WEAPON_2;
var DYN_WEAPON_3;
var DYN_WEAPON_4;
var DYN_WEAPON_5;
var DYN_WEAPON_6;
var DYN_WEAPON_7;
var DYN_WEAPON_8;
var DYN_WEAPON_9;
var FPS_SUFFIX_1;
var FPS_SUFFIX_2;
var FPS_NOT_AVAIL;
var FPS_IAS_CAP;
var OD_SETTINGS;
var OD_FANA;
var OD_WW;
var OD_BURST;
var OD_FRENZY;
var OD_SKILL;
var OD_CHAR;
var OD_IAS;
var OD_CWIAS;
var OD_WIAS;
var OD_FPS;
var OD_WEAPON;
var OD_H2H_1;
var OD_H2H_2;
var OD_C2H_1;
var OD_C2H_2;

if (LANG == "english")
{
  SKILL_STANDARD = "普通攻击(Standard)";
  SKILL_AMA_0    = "普通攻击(Standard)";
  SKILL_AMA_1    = "炮轰(Strafe)";
  SKILL_AMA_2    = "戳刺(Jab)";
  SKILL_AMA_3    = "刺爆(Impale) [*]";
  SKILL_AMA_4    = "击退(Fend) [*]";
  SKILL_BABA_0   = "普通攻击(Standard)";
  SKILL_BABA_1   = "双手挥击(Double Swing)";
  SKILL_BABA_2   = "双手投掷(Double Throw)";
  SKILL_BABA_3   = "狂乱(Frenzy)";
  SKILL_BABA_4   = "旋风(Whirlwind)";
  SKILL_BABA_5   = "专心(Concentrate)";
  SKILL_BABA_6   = "狂战士(Berserk)";
  SKILL_BABA_7   = "重击(Bash)";
  SKILL_BABA_8   = "击晕(Stun)";
  SKILL_PALA_0   = "普通攻击(Standard)";
  SKILL_PALA_1   = "热诚(Zeal)";
  SKILL_PALA_2   = "重击(Smite)";
  SKILL_SORC_0   = "普通攻击(Standard)";
  SKILL_SORC_1   = "连锁闪电(Chain Lightning)";
  SKILL_DRU_0    = "普通攻击(Standard)";
  SKILL_DRU_1    = "变身狼人(Werewolf)";
  SKILL_DRU_2    = "Werewolf - 狂怒(Fury)";
  SKILL_DRU_3    = "Werewolf - 野性狂暴(Feral Rage)";
  SKILL_DRU_4    = "Werewolf - Rabies";
  SKILL_DRU_5    = "Werewolf - 焰爪(Fire Claws)";
  SKILL_DRU_6    = "Werewolf - 饥饿(Hunger)";
  SKILL_DRU_7    = "变身熊人(Werebear)";
  SKILL_DRU_8    = "Werebear - 撞锤(Maul)";
  SKILL_DRU_9    = "Werebear - 焰爪(Fire Claws)";
  SKILL_DRU_10   = "Werebear - 饥饿(Hunger)";
  SKILL_ASSA_0   = "普通攻击(Standard)";
  SKILL_ASSA_1   = "虎击(Tiger Strike)";
  SKILL_ASSA_2   = "蛇击(Cobra Strike)";
  SKILL_ASSA_3   = "凤击(Phoenix Strike)";
  SKILL_ASSA_4   = "火焰抓(Fists of Fire)";
  SKILL_ASSA_5   = "雷击爪(Claws of Thunder)";
  SKILL_ASSA_6   = "寒冰刃(Blades of Ice)";
  SKILL_ASSA_7   = "双龙爪(Dragon Claw)";
  SKILL_ASSA_8   = "神龙摆尾(Dragon Tail)";
  SKILL_ASSA_9   = "安置陷阱(Trap placing)";
  SKILL_ACT2_0   = "戳刺(Jab)";
  GUI_BABA_1H    = "单手(One)";
  GUI_BABA_2H    = "双手(Two)";
  GUI_ASSA_NONE  = "无(none)";
  DYN_WEAPON_1   = "单手近战型武器(1Hand slashing weapon)";
  DYN_WEAPON_2   = "单手刺入型武器(1Hand thrusting weapon)";
  DYN_WEAPON_3   = "双手剑(2Hand sword)";
  DYN_WEAPON_4   = "双手刺入型武器(2Hand thrusting weapon)";
  DYN_WEAPON_5   = "普通双手武器(Normal 2Hand weapon)";
  DYN_WEAPON_6   = "弓(Bow)";
  DYN_WEAPON_7   = "十字弓(Crossbow)";
  DYN_WEAPON_8   = "投掷型武器(Throwing weapon)";
  DYN_WEAPON_9   = "爪类武器(Claw)";
  FPS_SUFFIX_1   = " 祯每次攻击(Frames per attack)";
  FPS_SUFFIX_2   = " 次攻击每秒(Attacks per second)";
  FPS_NOT_AVAIL  = "不可用数据(Not available)";
  FPS_IAS_CAP    = "已达攻速上限(Further IAS Useless)";
  OD_SETTINGS    = "Settings";
  OD_FANA        = "Fanaticism";
  OD_WW          = "Werewolf";
  OD_BURST       = "Burst of Speed";
  OD_FRENZY      = "Frenzy";
  OD_SKILL       = "Skill";
  OD_CHAR        = "Character";
  OD_IAS         = "IAS";
  OD_LWIAS       = "WIAS&nbsp;[left&nbsp;weapon]";
  OD_RWIAS       = "WIAS&nbsp;[right&nbsp;weapon]";
  OD_LCLAW       = "Left weapon";
  OD_RCLAW       = "Right weapon";
  OD_WIAS        = "WIAS";
  OD_FPS         = "Frames per attack";
  OD_WEAPON      = "Weapon";
  OD_H2H_1       = "one-handed";
  OD_H2H_2       = "two-handed";
  OD_FREQ        = "Attacks per second";
}


var capped    = 0;
var lastSkill = 0;
var lastType  = 0;
var lastC2H   = 0;
var firstCall = true;


function round(val, digits)
{
  str = String(val);
  if (str.lastIndexOf(".") == -1)
  {
     return Number(str);
  }
  else
  {
    return Number(str.substr(0,str.lastIndexOf(".")+digits+1));
  }
}

function engSort(a,b)
{
  if (a[0] > b[0])
    return 1;
  if (a[0] < b[0])
    return -1;
  return 0;
}

function gerSort(a,b)
{
  if (a[4] > b[4])
    return 1;
  if (a[4] < b[4])
    return -1;
  return 0;
}


function setCharValues(form)
{
  if (firstCall)
  {
    firstCall = false;

    weaponlist.sort(engSort);
    for (i=0; i < weaponlist.length; i++)
    {
      entry = new Option(weaponlist[i][0]);
      form.weapon.options[form.weapon.length] = entry;
      form.weapon.options[form.weapon.length-1].value = i;
      weaponlist[i][6] = i;
    }
    weaponlist.sort(gerSort);
    for (i=0; i < weaponlist.length; i++)
    {
      entry = new Option(weaponlist[i][4]);
      form.waffe.options[form.waffe.length] = entry;
      form.waffe.options[form.waffe.length-1].value = weaponlist[i][6];
    }
    weaponlist.sort(engSort);

    form.weapon.selectedIndex = 0;
    form.waffe.selectedIndex = 1;
  }


  var uchar = form.uchar.options[form.uchar.options.selectedIndex].value;

  
  while (form.skill.length > 0)
  {
    form.skill.options[0] = null;
  }
  
  switch(String(uchar))
  {
    case "0":
      entry = new Option(SKILL_AMA_0);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 0;
      entry = new Option(SKILL_AMA_1);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 1;
      entry = new Option(SKILL_AMA_2);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 2;
      entry = new Option(SKILL_AMA_3);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 3;
      entry = new Option(SKILL_AMA_4);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 4;
      break;
    case "1":
      entry = new Option(SKILL_BABA_0);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 0;
      entry = new Option(SKILL_BABA_1);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 1;
      entry = new Option(SKILL_BABA_2);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 2;
      entry = new Option(SKILL_BABA_3);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 3;
      entry = new Option(SKILL_BABA_4);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 4;
      entry = new Option(SKILL_BABA_5);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 5;
      entry = new Option(SKILL_BABA_6);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 6;
      entry = new Option(SKILL_BABA_7);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 7;
      entry = new Option(SKILL_BABA_8);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 8;
      break;
    case "3":
      entry = new Option(SKILL_PALA_0);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 0;
      entry = new Option(SKILL_PALA_1);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 1;
      entry = new Option(SKILL_PALA_2);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 2;
      break;
    case "4":
      entry = new Option(SKILL_SORC_0);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 0;
      entry = new Option(SKILL_SORC_1);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 1;
      break;
    case "5":
      entry = new Option(SKILL_DRU_0);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 0;
      entry = new Option(SKILL_DRU_1);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 1;
      entry = new Option(SKILL_DRU_2);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 2;
      entry = new Option(SKILL_DRU_3);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 3;
      entry = new Option(SKILL_DRU_4);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 4;
      entry = new Option(SKILL_DRU_5);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 5;
      entry = new Option(SKILL_DRU_6);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 6;
      entry = new Option(SKILL_DRU_7);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 7;
      entry = new Option(SKILL_DRU_8);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 8;
      entry = new Option(SKILL_DRU_9);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 9;
      entry = new Option(SKILL_DRU_10);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 10;
      break;
    case "6":
      entry = new Option(SKILL_ASSA_0);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 0;
      entry = new Option(SKILL_ASSA_1);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 1;
      entry = new Option(SKILL_ASSA_2);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 2;
      entry = new Option(SKILL_ASSA_3);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 3;
      entry = new Option(SKILL_ASSA_4);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 4;
      entry = new Option(SKILL_ASSA_5);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 5;
      entry = new Option(SKILL_ASSA_6);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 6;
      entry = new Option(SKILL_ASSA_7);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 7;
      entry = new Option(SKILL_ASSA_8);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 8;
      entry = new Option(SKILL_ASSA_9);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 9;
      break;
    case "7":
      entry = new Option(SKILL_ACT2_0);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 0;
      break;
    default:
      entry = new Option(SKILL_STANDARD);
      form.skill.options[form.skill.length] = entry;
      form.skill.options[form.skill.length-1].value = 0;
      break;
  }
  form.skill.selectedIndex = 0;
  changeSkill(form, true);
  changeWeapon(form);
}


function changeDeWeapon(form)
{
  form.weapon.selectedIndex = form.waffe.options[document.theForm.waffe.selectedIndex].value;
  changeWeapon(form);
}


function changeEnWeapon(form)
{
  value = form.weapon.selectedIndex;
  for (i=0; i<291; i++)
  {
    if (form.waffe.options[i].value == value)
    {
      form.waffe.options[i].selected = true;
      break;
    }
  }
  changeWeapon(form);
}


function changeLeftWeapon(form)
{
  var uchar  = parseInt(form.uchar.options[form.uchar.options.selectedIndex].value);
  var weapon = form.weapon.options.selectedIndex;
  var type   = weaponlist[weapon][2];

  if (((form.c2h.length > 1) && (form.c2h.selectedIndex == 0)) || (form.c2h.length < 2))
  {
    while (form.cwias.length > 0)
    {
      form.cwias.options[0] = null;
    }
    entry = new Option("-");
    form.cwias.options[form.cwias.length] = entry;
    form.cwias.options[form.cwias.length-1].value = 0;
  }
  else if ((form.c2h.length > 1) && (lastC2H == 0))
  {
    while (form.cwias.length > 0)
    {
      form.cwias.options[0] = null;
    }
    for(i = 0; i < 25; i++)
    {
      entry = new Option(String(i*5));
      form.cwias.options[form.cwias.length] = entry;
      form.cwias.options[form.cwias.length-1].value = String(i*5);
    }
    form.cwias.selectedIndex = 0;
  }

  lastC2H = form.c2h.selectedIndex;
}


function changeWeapon(form)
{
  var uchar  = parseInt(form.uchar.options[form.uchar.options.selectedIndex].value);
  var weapon = form.weapon.options.selectedIndex;
  var type   = weaponlist[weapon][2];

  if ((form.h2h.length > 1) && ((uchar != 1) || (type != 3)))
  {
    while (form.h2h.length > 0)
    {
      form.h2h.options[0] = null;
    }
    entry = new Option("-");
    form.h2h.options[form.h2h.length] = entry;
    form.h2h.options[form.h2h.length-1].value = 0;
  }
  else if ((uchar == 1) && (type == 3) && (form.h2h.length < 2))
  {
    while (form.h2h.length > 0)
    {
      form.h2h.options[0] = null;
    }
    entry = new Option(GUI_BABA_2H);
    form.h2h.options[form.h2h.length] = entry;
    form.h2h.options[form.h2h.length-1].value = 0;
    entry = new Option(GUI_BABA_1H);
    form.h2h.options[form.h2h.length] = entry;
    form.h2h.options[form.h2h.length-1].value = 1;
    form.h2h.selectedIndex = 0;
  }

  if (((uchar == 6) && (type == 9))
     || ((uchar == 1) &&  ((type == 1) || (type == 2) || (type == 8) ||
        ((type == 3) && ((form.h2h.length < 2) || (form.h2h.selectedIndex == 1))))))
  {
    while (form.c2h.length > 0)
    {
      form.c2h.options[0] = null;
    }

    if (uchar == 6)
    {
      entry = new Option("["+GUI_ASSA_NONE+"]");
      form.c2h.options[form.c2h.length] = entry;
      form.c2h.options[form.c2h.length-1].value = 0;

      if (LANG == 'german')
        weaponlist.sort(gerSort);
      for (i=0; i < weaponlist.length; i++)
      {
        if (weaponlist[i][2] == 9)
        {
          if (LANG == 'german')
            entry = new Option(weaponlist[i][4]);
          else
            entry = new Option(weaponlist[i][0]);
          form.c2h.options[form.c2h.length] = entry;
          form.c2h.options[form.c2h.length-1].value = weaponlist[i][6];
        }
      }
      weaponlist.sort(engSort);
    }
    else
    {
      entry = new Option("["+GUI_ASSA_NONE+"]");
      form.c2h.options[form.c2h.length] = entry;
      form.c2h.options[form.c2h.length-1].value = 0;

      if (LANG == 'german')
        weaponlist.sort(gerSort);
      for (i=0; i < weaponlist.length; i++)
      {
        if ((weaponlist[i][2] == 1) || (weaponlist[i][2] == 2)
            || (weaponlist[i][2] == 3) || (weaponlist[i][2] == 8))
        {
          if (LANG == 'german')
            entry = new Option(weaponlist[i][4]);
          else
            entry = new Option(weaponlist[i][0]);
          form.c2h.options[form.c2h.length] = entry;
          form.c2h.options[form.c2h.length-1].value = weaponlist[i][6];
        }
      }
      weaponlist.sort(engSort);
    }
    form.c2h.selectedIndex = 0;
  }
  else
  {
    while (form.c2h.length > 0)
    {
      form.c2h.options[0] = null;
    }
    entry = new Option("-");
    form.c2h.options[form.c2h.length] = entry;
    form.c2h.options[form.c2h.length-1].value = 0;
  }

  changeLeftWeapon(form);
  changeSkill(form);
}


function changeSkill(form, newChar)
{
  var uchar  = form.uchar.options[form.uchar.options.selectedIndex].value;
  var skill  = parseInt(form.skill.options[form.skill.options.selectedIndex].value);
  var weapon = form.weapon.options.selectedIndex;
  var type   = weaponlist[weapon][2];

  // **************************************************************************
  // IAS
  if (!((uchar == 1) && (skill == 4))) // alle ausser ww-baba
  {
    if ((newChar) || ((uchar == 1) && (lastSkill == 4)))
    {
      while (form.ias.length > 0)
      {
        form.ias.options[0] = null;
      }
      for(i = 0; i < 61; i++)
      {
        entry = new Option(String(i*5));
        form.ias.options[form.ias.length] = entry;
        form.ias.options[form.ias.length-1].value = String(i*5);
      }
      form.ias.selectedIndex = 0;
    }
  }
  else // ww-baba
  {
    while (form.ias.length > 0)
    {
      form.ias.options[0] = null;
    }
    entry = new Option("-");
    form.ias.options[form.ias.length] = entry;
    form.ias.options[form.ias.length-1].value = 0;
    form.ias.selectedIndex = 0;
  }

  // **************************************************************************
  // Weapon-IAS
  if (((uchar == 5) && (skill != 0)) ||
      ((uchar == 1)) ||
      ((uchar == 6) && (type == 9)) ) // weredruid/baba/assa left claw
  {
    if ((newChar) ||
        ((uchar == 5) && (lastSkill == 0)) ||
        ((uchar == 1) && (lastSkill != 4)) ||
        ((uchar == 6) && (lastType != 9))  )
    {
      while (form.weaponias.length > 0)
      {
        form.weaponias.options[0] = null;
      }
      for(i = 0; i < 25; i++)
      {
        entry = new Option(String(i*5));
        form.weaponias.options[form.weaponias.length] = entry;
        form.weaponias.options[form.weaponias.length-1].value = String(i*5);
      }
      form.weaponias.selectedIndex = 0;
    }
  }
  else // others
  {
    while (form.weaponias.length > 0)
    {
      form.weaponias.options[0] = null;
    }
    entry = new Option("-");
    form.weaponias.options[form.weaponias.length] = entry;
    form.weaponias.options[form.weaponias.length-1].value = 0;
    form.weaponias.selectedIndex = 0;
  }

  // **************************************************************************
  // Werewolf
  if ((uchar == 5) && ((skill > 0) && (skill < 7)))
  {
    if ((newChar) || ((uchar == 5) && (lastSkill != 1) && (lastSkill != 3)))
    {
      while (form.ww.length > 0)
      {
        form.ww.options[0] = null;
      }
      for(i = 1; i < 31; i++)
      {
        entry = new Option(String(i));
        form.ww.options[form.ww.length] = entry;
        form.ww.options[form.ww.length-1].value = SD_werwolf[i-1];
      }
      form.ww.selectedIndex = 0;
    }
  }
  else // other chars
  {
    while (form.ww.length > 0)
    {
      form.ww.options[0] = null;
    }
    entry = new Option("-");
    form.ww.options[form.ww.length] = entry;
    form.ww.options[form.ww.length-1].value = 0;
    form.ww.selectedIndex = 0;
  }

  // **************************************************************************
  // Burst Of Speed
  if ((uchar == 6) && (newChar)) // assassin
  {
    while (form.burst.length > 0)
    {
      form.burst.options[0] = null;
    }
    for(i = 0; i < 31; i++)
    {
      entry = new Option(String(i));
      form.burst.options[form.burst.length] = entry;
      form.burst.options[form.burst.length-1].value = SD_burstofspeed[i];
    }
    form.burst.selectedIndex = 0;
  }
  else if (uchar != 6) // other chars
  {
    while (form.burst.length > 0)
    {
      form.burst.options[0] = null;
    }
    entry = new Option("-");
    form.burst.options[form.burst.length] = entry;
    form.burst.options[form.burst.length-1].value = 0;
    form.burst.selectedIndex = 0;
  }

  // **************************************************************************
  // Frenzy
  if ((uchar == 1) && (newChar)) // barbarian
  {
    while (form.frenzy.length > 0)
    {
      form.frenzy.options[0] = null;
    }
    for(i = 0; i < 41; i++)
    {
      entry = new Option(String(i));
      form.frenzy.options[form.frenzy.length] = entry;
      form.frenzy.options[form.frenzy.length-1].value = SD_frenzy[i];
    }
    form.frenzy.selectedIndex = 0;
  }
  else if (uchar != 1) // other chars
  {
    while (form.frenzy.length > 0)
    {
      form.frenzy.options[0] = null;
    }
    entry = new Option("-");
    form.frenzy.options[form.frenzy.length] = entry;
    form.frenzy.options[form.frenzy.length-1].value = 0;
    form.frenzy.selectedIndex = 0;
  }

  lastSkill = skill;
  lastType  = type;
  compute (form);
}

function popup()
{
window.open("weaponspeed-tab.php?lang=english","Infoq","width=400,height=500,screenX=200,screenY=200,resizable=yes,dependent=yes,scrollbars=yes");
}

function cap(val, min, max)
{
  if (val >= max)
  {
    capped = 1;
    return max;
  }
  else if (val < min)
    return min;
  return val;
}

function ww_cap(val)
{
  if (val < 12)
    return 4;
  if (val < 15)
    return 6;
  if (val < 18)
    return 8;
  if (val < 20)
    return 10;
  if (val < 23)
    return 12;
  if (val < 26)
    return 14;
  else
    return 16;
}

function calculateFps(uchar, skill, r_weapon, l_weapon, item_ias, r_ias, l_ias, skill_ias, h2h, weaponlist)
{
  var fps = Number.NaN;

  // general initialization
  var r_base = -weaponlist[r_weapon][1];
  var l_base = r_base;
  var effias = skill_ias + r_base + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
  var type   = weaponlist[r_weapon][2];
  var l_type = type;
  if (l_weapon >= 0)
  {
    l_base = -weaponlist[l_weapon][1];
    l_type = weaponlist[l_weapon][2];
    if ((weaponlist[l_weapon][5] >= 0) && (weaponlist[l_weapon][5] != uchar))
      return Number.NaN;
  }
  if ((weaponlist[r_weapon][5] >= 0) && (weaponlist[r_weapon][5] != uchar))
    return Number.NaN;

  // Smite weapon check
  if ((uchar == 3) && (skill == 2) && (type != 1) && (type != 2) && (type != 8))
    return Number.NaN;

  // set proper base frames
  var baseframe = baseframes[type-1][uchar];
  // skill specific attack baseframes
  // Zeal
  if ((uchar == 3) && (skill == 1)) baseframe = 6;
  // Smite
  if ((uchar == 3) && (skill == 2)) baseframe = 11;
  // 2H Zeal
  if ((uchar == 3) && (skill == 1) && ((type == 3) || (type == 4))) baseframe = 7;
  if ((uchar == 3) && (skill == 1) && (type == 5)) baseframe = 8;
  // Strafe + Bow
  if ((uchar == 0) && (skill == 1) && (type == 6)) baseframe = 3;
  // Strafe + XBow
  if ((uchar == 0) && (skill == 1) && (type == 7)) baseframe = 5;
  // Fend
  if ((uchar == 0) && (skill == 4)) baseframe = 6;

  // Paladin with 2H swords
  if ((uchar == 3) && (skill == 0) && (type == 3))
  {
    effias = cap (effias, -100, 75);
    var fps1 = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256))-1;
    var fps2 = Math.ceil(256*(baseframe+2)/Math.floor((100+effias)/100*256))-1;
    fps = (fps1+fps2)/2;
  }
  //***************************************************************************
  // Zeal
  else if ((uchar == 3) && (skill == 1))
  {
    effias = cap (effias, -100, 75);
    if ((type == 6)||(type == 7)||(type == 9))
    {
      fps = Number.NaN;
    }
    else
    {
      fps = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256));
    }
  }
  //***************************************************************************
  // Strafe
  else if ((uchar == 0) && (skill == 1))
  {
    effias = cap (effias, -100, 75);
    if (type == 6)
    {
      fps = Math.ceil(baseframe/((100+effias)/100));
    }
    else if (type == 7)
    {
      fps = baseframe/((100+effias)/100);
      if (fps > (parseInt(fps)+0.5)) fps = parseInt(fps) + 1;
      else if (fps > parseInt(fps)) fps = parseInt(fps) + 0.5;
    }
    else if (baseframe > 5)
    {
      fps = Number.NaN;
    }
  }
  //***************************************************************************
  // Fend
  else if ((uchar == 0) && (skill == 4))
  {
    if (type == 4) //spears
    {
      fps = 10;
      for (i=0; i < SD_fend_spear.length; i++)
      {
        if (effias >= SD_fend_spear[i]) fps -= 1;
      }
      if (fps <= 5)
      {
        fps    = 5;
        capped = 1;
      }
    }
    else if (type == 8) // javelins
    {
      fps = 10;
      for (i=0; i < SD_fend_jav.length; i++)
      {
        if (effias >= SD_fend_jav[i]) fps -= 1;
      }
      if (fps <= 5)
      {
        fps    = 5;
        capped = 1;
      }
    }
    else
    {
      fps = Number.NaN;
    }
  }
  //***************************************************************************
  // Jab with spears
  else if ((uchar == 0) && (skill == 2) && (type != 8))
  {
    fps = 14;
    for (i=0; i < SD_jab.length; i++)
    {
      if (effias >= SD_jab[i]) fps -= 0.5;
    }

    if (type != 4)
    {
      fps = Number.NaN;
    }
    else if (fps <= 4)
    {
      fps    = 4;
      capped = 1;
    }
  }
  //***************************************************************************
  // Aufspie遝n
  else if ((uchar == 0) && (skill == 3))
  {
    if (effias > 104)
    {
      effias = 75;
      capped = 1;
    }
    fps = Math.ceil(128*(35+1)/Math.floor((69+effias)/69*128));
  }
  //***************************************************************************
  // Barbar normal
  else if ((uchar == 1) && (skill == 0))
  {
    if ((type == 1) || (type == 2) || (type == 8) || ((type == 3) && (h2h > 0)))
    {
      effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
      var speed_inc = cap(100 + (r_base + l_base) / 2 + effias, 15, 175);
      var fps1 = Math.ceil(256 * 16 / Math.floor(256 * speed_inc / 100)) - 1;

      effias = skill_ias + Math.floor(120*(item_ias+l_ias)/(120+item_ias+l_ias));
      var speed_inc = cap(100 + (r_base + l_base) / 2  + l_base - r_base + effias, 15, 175);
      var fps2 = Math.ceil(256 * 12 / Math.floor(256 * speed_inc / 100)) - 1;

      fps = (fps1 + fps2) / 2;
    }
    else
    {
      effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
      var speed_inc = cap(100 + (r_base + l_base) / 2 + effias, 15, 175);
      fps = Math.ceil(256 * (baseframe+1) / Math.floor(256 * speed_inc / 100)) - 1;
    }
  }
  //***************************************************************************
  // Doppelschwung
  else if ((uchar == 1) && (skill == 1))
  {
    effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
    var speed_inc = cap(120 + (r_base + l_base) / 2 + effias, 15, 175);
    fps = Math.ceil(256 * 17 / Math.floor(256 * speed_inc / 100)) / 2;
  }
  //***************************************************************************
  
  else if ((uchar == 1) && (skill > 4))
  {
    if ((type == 3) && (h2h > 0))
    {
      baseframe = 15;
    }
    effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
    var speed_inc = cap(100 + (r_base + l_base) / 2 + effias, 15, 175);
    fps = Math.ceil(256 * (baseframe+1) / Math.floor(256 * speed_inc / 100)) - 1;
  }
  //***************************************************************************
  // Doppelwurf / Sto?mit Wurfspeeren
  else if (((uchar == 1) && (skill == 2)) || ((uchar == 0) && (skill == 2) && (type == 8)))
  {
    effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
    var speed_inc = cap(70 + (r_base + l_base) / 2 + effias, 15, 175);
    fps = Math.ceil(256 * 12 / Math.floor(256 * speed_inc / 100)) / 2;
  }
  //***************************************************************************
  // Raserei
  else if ((uchar == 1) && (skill == 3))
  {
    effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
    var speed_inc = cap(70 + (r_base + l_base) / 2 + effias, 15, 175);
    fps = Math.ceil(256 * 17 / Math.floor(256 * speed_inc / 100)) / 2;
  }
  //***************************************************************************
  // Wirbelwind
  else if ((uchar == 1) && (skill == 4))
  {
    var fps1 = 0;
    var speed_inc = cap(100 + r_ias + r_base, 15, 175);
    if ((type < 4) || (type == 8))
      fps1 = ww_cap(Math.floor(256 * 16 / Math.floor(256 * speed_inc /100)));
    else
      fps1 = ww_cap(Math.floor(256 * 19 / Math.floor(256 * speed_inc /100)));

    var fps2 = fps1;
    if (l_weapon >= 0)
    {
      var speed_inc = cap(100 + l_ias + l_base, 15, 175);
      if ((l_type < 4) || (l_type == 8))
        fps2 = ww_cap(Math.floor(256 * 16 / Math.floor(256 * speed_inc /100)));
      else
        fps2 = ww_cap(Math.floor(256 * 19 / Math.floor(256 * speed_inc /100)));
    }

    fps = (fps1 + fps2) / 2;

    if (l_weapon >= 0)
    {
      fps = fps / 2;
    }
  }
  //***************************************************************************
  // Werformen
  else if ((uchar == 5) && (skill > 0))
  {
    var prev = Number.NaN;
    var base = Number.NaN;
    effias   = cap (effias, -100, 75);

    if (skill < 7) // Werwolf
    {
      baseframe = baseframes[type-1][uchar+1];
      prev = 9;
      base = 13;
      if ((skill == 6) || (skill == 4)) // Hunger/Tollwut
      {
        base = 10;
      }
      else if (skill == 2) // Fury
      {
        base = 7;
      }
    }
    else // Werb鋜
    {
      baseframe = baseframes[type-1][uchar+2];
      prev = 10;
      base = 12;
      if (skill == 10)
      {
        base = 10;
      }
    }

    var delay = Math.floor(256 * baseframe / Math.floor(256 * (100 + r_ias + r_base) / 100));
    var anim_speed = Math.floor(prev * 256 / delay);
    if (skill == 2)
    {
      fps = Math.ceil(256 * base / Math.floor((100 + effias) / 100 * anim_speed));
    }
    else
    {
      fps = Math.ceil(256 * base / Math.floor((100 + effias) / 100 * anim_speed)) - 1;
    }
  }
  //***************************************************************************
  // Assassin
  else if (uchar == 6)
  {
    var fps1;
    var fps2;
    var fps3;

    if ((skill > 3) && (l_weapon >= 0))
    {
      effias  = (r_base + l_base) / 2 + skill_ias + Math.floor(120 * (item_ias + r_ias) / (120 + item_ias + r_ias));
      ceffias = (r_base + l_base) / 2 + skill_ias + Math.floor(120 * (item_ias + l_ias) / (120 + item_ias + l_ias));
    }
    else
    {
      effias  = r_base + skill_ias + Math.floor(120 * (item_ias + r_ias) / (120 + item_ias + r_ias));
      ceffias = l_base + skill_ias + Math.floor(120 * (item_ias + l_ias) / (120 + item_ias + l_ias));
    }

    if ((((skill > 3) && (skill < 8)) && (type != 9)) ||
        ((skill < 4) && (skill != 0) && ((type == 6) || (type == 7))))
    {
      fps = Number.NaN;
    }
    else if (skill == 0) // standard
    {
      if (type != 9)
      {
        fps = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256))-1;
      }
      else
      {
        fps1 = 16;
        fps2 = 17;
        fps3 = 17;
        for (i=0; i < SD_clawslash_right.length; i++)
        {
          if (effias >= SD_clawslash_right[i]) fps1--;
        }
        for (i=0; i < SD_clawthrust_right.length; i++)
        {
          if (effias >= SD_clawthrust_right[i]) fps2--;
        }
        for (i=0; i < SD_clawslash_left.length; i++)
        {
          if (ceffias >= SD_clawslash_left[i]) fps3--;
        }
        if (l_weapon < 0) // 1H
        {
          fps = (fps1+fps2)/2;
          if ((fps1 <= 7) && (fps2 <= 8))
          {
            fps    = (7+8)/2;
            capped = 1;
          }
        }
        else // 2H
        {
          fps = (fps1+fps2+2*fps3)/4;
          if ((fps1 <= 7) && (fps2 <= 8) && (fps3 <= 8))
          {
            fps    = (7+8+2*8)/4;
            capped = 1;
          }
        }
      }
    }
    else if (skill < 4) // strike charger
    {
      if (type != 9)
      {
        fps = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256))-1;
      }
      else
      {
        fps = 16;
        for (i=0; i < SD_clawslash_right.length; i++)
        {
          if (effias >= SD_clawslash_right[i]) fps--;
        }
        if (fps <= 7)
        {
          fps    = 7;
          capped = 1;
        }
      }
    }
    else if (skill < 8) // claw charger/finisher
    {
      if (l_weapon < 0) // 1H
      {
        if (skill == 7)
        {
          fps = Number.NaN;
        }
        else
        {
          fps = 22;
          for (i=0; i < SD_clawcharge_1H.length; i++)
          {
            if (effias >= SD_clawcharge_1H[i]) fps--;
          }
          if (fps <= 7)
          {
            fps    = 7;
            capped = 1;
          }
        }
      }
      else // 2H
      {
        fps = 28;
        for (i=0; i < SD_clawcharge_2H.length; i++)
        {
          if (effias >= SD_clawcharge_2H[i]) fps--;
        }
        if (fps <= 10)
        {
          fps    = 10;
          capped = 1;
        }
        fps = fps/2;
      }
    }
    else if (skill == 8) // dragon tail
    {
      fps = 26;
      for (i=0; i < SD_dragontail.length; i++)
      {
        if (effias >= SD_dragontail[i]) fps--;
      }
      if (fps <= 7)
      {
        fps    = 7;
        capped = 1;
      }
    }
    else // traps
    {
      fps = Math.ceil(256*(15+1)/Math.floor((100+effias)/100*256))-1;
      if (fps <= 9)
      {
        fps    = 9;
        capped = 1;
      }
    }
  }
  //***************************************************************************
  // Chainlightning
  else if ((uchar == 4) && (skill == 1))
  {
    if (type != 9)
    {
      fps = 38;
      for (i=0; i < SD_chainlightning.length; i++)
      {
        if (effias > SD_chainlightning[i]) fps--;
      }
      if (fps <= 11)
      {
        fps    = 11;
        capped = 1;
      }
    }
  }
  //***************************************************************************
  // Act 2 mercenary (Jab)
  else if (uchar == 7)
  {
    if (weaponlist[r_weapon][3] != 2)
      return Number.NaN;

    fps = 21;
    for (i=0; i < SD_act2_jab.length; i++)
    {
      if (effias >= SD_act2_jab[i]) fps -= 1;
    }
    fps = fps/2.0;

    if (fps <= 5)
    {
      fps    = 5;
      capped = 1;
    }
  }
  //***************************************************************************
  // Act 1 mercenary
  else if (uchar == 8)
  {
    if (weaponlist[r_weapon][3] != 1)
      return Number.NaN;

    fps = 18;
    for (i=0; i < SD_act1_standard.length; i++)
    {
      if (effias >= SD_act1_standard[i]) fps -= 1;
    }

    if (fps <= 9)
    {
      fps    = 9;
      capped = 1;
    }
  }
  //***************************************************************************
  // Act 5 mercenary
  else if (uchar == 9)
  {
    if (weaponlist[r_weapon][3] != 3)
      return Number.NaN;

    fps = 22;
    for (i=0; i < SD_act5_standard.length; i++)
    {
      if (effias >= SD_act5_standard[i]) fps -= 1;
    }

    if (fps <= 10)
    {
      fps    = 10;
      capped = 1;
    }
  }
  else
  {
    effias = cap (effias, -100, 75);
    fps    = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256))-1;
  }
  return fps;
}

function compute(form)
{
  var fps       = 0; // the holy grail ;)
  capped        = 0;
  var r_weapon  = -1;
  var l_weapon  = -1;
  var r_ias     = 0;
  var l_ias     = 0;
  var item_ias  = 0;
  var skill_ias = 0;

  var uchar     = parseInt(form.uchar.options[form.uchar.options.selectedIndex].value);
  var skill     = parseInt(form.skill.options[form.skill.options.selectedIndex].value);
  var fana      = parseInt(form.fana.options[form.fana.options.selectedIndex].value);
  var ww        = parseInt(form.ww.options[form.ww.options.selectedIndex].value);
  var burst     = parseInt(form.burst.options[form.burst.options.selectedIndex].value);
  var frenzyval = parseInt(form.frenzy.options[form.frenzy.options.selectedIndex].value);
  var h2h       = form.h2h.options.selectedIndex;
  var c2h       = form.c2h.options.selectedIndex;

  r_weapon  = form.weapon.options.selectedIndex;
  r_ias     = parseInt(form.weaponias.options[form.weaponias.options.selectedIndex].value);
  item_ias  = parseInt(form.ias.options[form.ias.options.selectedIndex].text);
  if (isNaN(item_ias)) item_ias = 0;

  if (c2h > 0)
  {
    l_weapon  = parseInt(form.c2h.options[form.c2h.options.selectedIndex].value);
    l_ias     = parseInt(form.cwias.options[form.cwias.options.selectedIndex].value);
  }

  skill_ias = fana + frenzyval + ww + burst;

  //------------ calculate fps -------------//
  var fps =   calculateFps(uchar, skill, r_weapon, l_weapon, item_ias, r_ias, l_ias, skill_ias, h2h, weaponlist);


  // print results
  var weapontype = "";
  var fpsString1 = round(fps, 2) + FPS_SUFFIX_1;
  var fpsString2 = "";
  var spsString  = round(25/fps, 1) + FPS_SUFFIX_2;
  if (isNaN(fps))
  {
    fpsString1 = FPS_NOT_AVAIL;
    spsString  = FPS_NOT_AVAIL;
  }
  switch (String(weaponlist[r_weapon][2]))
  {
    case "1": weapontype = DYN_WEAPON_1; break;
    case "2": weapontype = DYN_WEAPON_2; break;
    case "3": weapontype = DYN_WEAPON_3; break;
    case "4": weapontype = DYN_WEAPON_4; break;
    case "5": weapontype = DYN_WEAPON_5; break;
    case "6": weapontype = DYN_WEAPON_6; break;
    case "7": weapontype = DYN_WEAPON_7; break;
    case "8": weapontype = DYN_WEAPON_8; break;
    case "9": weapontype = DYN_WEAPON_9; break;
  }
  if (capped > 0) fpsString2 = FPS_IAS_CAP;

  form.weapontype1.value = weapontype + " [" + weaponlist[r_weapon][1] + "]";
  form.fps1.value        = fpsString1;
  form.fps2.value        = fpsString2;
  form.sps1.value        = spsString;
}


function computeTable()
{
  var fps       = 0; // the holy grail ;)
  capped        = 0;
  var r_weapon  = -1;
  var l_weapon  = -1;
  var r_ias     = 0;
  var l_ias     = 0;
  var item_ias  = 0;
  var skill_ias = 0;

  var uchar     = parseInt(opener.document.theForm.uchar.options[opener.document.theForm.uchar.options.selectedIndex].value);
  var skill     = parseInt(opener.document.theForm.skill.options[opener.document.theForm.skill.options.selectedIndex].value);
  var fana      = parseInt(opener.document.theForm.fana.options[opener.document.theForm.fana.options.selectedIndex].value);
  var ww        = parseInt(opener.document.theForm.ww.options[opener.document.theForm.ww.options.selectedIndex].value);
  var burst     = parseInt(opener.document.theForm.burst.options[opener.document.theForm.burst.options.selectedIndex].value);
  var frenzyval = parseInt(opener.document.theForm.frenzy.options[opener.document.theForm.frenzy.options.selectedIndex].value);
  var h2h       = opener.document.theForm.h2h.options.selectedIndex;
  var c2h       = opener.document.theForm.c2h.options.selectedIndex;
  var isWIAS    = (opener.document.theForm.weaponias.options[opener.document.theForm.weaponias.options.selectedIndex].text != "-");
  var isLWIAS   = (opener.document.theForm.cwias.options[opener.document.theForm.cwias.options.selectedIndex].text != "-");

  r_weapon  = opener.document.theForm.weapon.options.selectedIndex;
  r_ias     = parseInt(opener.document.theForm.weaponias.options[opener.document.theForm.weaponias.options.selectedIndex].value);
  item_ias  = parseInt(opener.document.theForm.ias.options[opener.document.theForm.ias.options.selectedIndex].text);

  if (c2h > 0)
  {
    l_weapon  = parseInt(opener.document.theForm.c2h.options[opener.document.theForm.c2h.options.selectedIndex].value);
    l_ias     = parseInt(opener.document.theForm.cwias.options[opener.document.theForm.cwias.options.selectedIndex].value);
  }

  skill_ias = fana + frenzyval + ww + burst;

  document.write("<table align=\"center\" border=0 cellpadding=5 cellspacing=2>");
  document.write("<tr class=\"one\"><td class=\"header\" colspan=\"3\" align=\"center\">"+OD_SETTINGS+"</td></tr>");

  document.write("<tr class=\"two\"><td class=\"one\"><b>"+OD_CHAR);
  document.write("</b></td><td colspan=\"2\">"+opener.document.theForm.uchar.options[opener.document.theForm.uchar.options.selectedIndex].text+"</td></tr>");

  if (uchar == 6)
    document.write("<tr class=\"two\"><td class=\"one\"><b>"+OD_RCLAW);
  else
    document.write("<tr class=\"two\"><td class=\"one\"><b>"+OD_WEAPON);

  if (LANG != "english")
  {
    document.write("</b></td><td colspan=\"2\">"+opener.document.theForm.waffe.options[opener.document.theForm.waffe.options.selectedIndex].text);
    document.write(" / "+opener.document.theForm.weapon.options[opener.document.theForm.weapon.options.selectedIndex].text);
  }
  else
  {
    document.write("</b></td><td colspan=\"2\">"+opener.document.theForm.weapon.options[opener.document.theForm.weapon.options.selectedIndex].text);
    document.write(" / "+opener.document.theForm.waffe.options[opener.document.theForm.waffe.options.selectedIndex].text);
  }
  if (opener.document.theForm.h2h.options[opener.document.theForm.h2h.options.selectedIndex].text != "-")
  {
    if (opener.document.theForm.h2h.options.selectedIndex == 0)
      document.write(",<br><span class=\"small\">"+OD_H2H_2+"</span>");
    else
      document.write(",<br><span class=\"small\">"+OD_H2H_1+"</span>");
  }
  document.write("</td></tr>");
  if (opener.document.theForm.c2h.options[opener.document.theForm.c2h.options.selectedIndex].text != "-")
  {
    if (opener.document.theForm.c2h.options.selectedIndex != 0)
    {
      document.write("<tr class=\"two\"><td class=\"one\"><b>"+OD_LCLAW);
      document.write("</b></td><td colspan=\"2\">"+opener.document.theForm.c2h.options[opener.document.theForm.c2h.options.selectedIndex].text+"</td></tr>");
    }
  }

  document.write("<tr class=\"two\"><td class=\"one\"><b>"+OD_SKILL);
  document.write("</b></td><td colspan=\"2\">"+opener.document.theForm.skill.options[opener.document.theForm.skill.options.selectedIndex].text+"</td></tr>");

  if ((isWIAS) && (uchar != 6) && !((uchar == 1)&&(skill > 0)))
  {
    if (isNaN(item_ias)) ias = 0;
    document.write("<tr class=\"two\"><td class=\"one\">"+OD_IAS);
    document.write("</td><td colspan=\"2\">"+item_ias+" %</td></tr>");
  }
  if ((isWIAS) && (uchar == 6) || ((uchar == 1) && (skill != 4)))
  {
    if (isNaN(r_ias)) r_ias = 0;
    document.write("<tr class=\"two\"><td class=\"one\">"+OD_RWIAS);
    document.write("</td><td colspan=\"2\">"+r_ias+" %</td></tr>");
    isWIAS = false;
  }
  if ((isLWIAS) && (c2h > 0))
  {
    if (isNaN(l_ias)) l_ias = 0;
    document.write("<tr class=\"two\"><td class=\"one\">"+OD_LWIAS);
    document.write("</td><td colspan=\"2\">"+l_ias+" %</td></tr>");
  }

  if (ww > 0)
  {
    document.write("<tr class=\"two\"><td class=\"one\">"+OD_WW);
    document.write("</td><td colspan=\"2\">Level "+(opener.document.theForm.ww.options.selectedIndex+1)+"</td></tr>");
  }
  if (burst > 0)
  {
    document.write("<tr class=\"two\"><td class=\"one\">"+OD_BURST);
    document.write("</td><td colspan=\"2\">Level "+opener.document.theForm.burst.options.selectedIndex+"</td></tr>");
  }
  if (frenzyval > 0)
  {
    document.write("<tr class=\"two\"><td class=\"one\">"+OD_FRENZY);
    document.write("</td><td colspan=\"2\">Level "+opener.document.theForm.frenzy.options.selectedIndex+"</td></tr>");
  }
  if (fana > 0)
  {
    document.write("<tr class=\"two\"><td class=\"one\">"+OD_FANA);
    document.write("</td><td colspan=\"2\">Level "+opener.document.theForm.fana.options.selectedIndex+"</td></tr>");
  }

  if (isWIAS)
  {
    if (uchar == 6)
      document.write("<tr class=\"header\"><td align=\"center\"><b>"+OD_RWIAS);
    else
      document.write("<tr class=\"header\"><td align=\"center\"><b>"+OD_WIAS);

    r_ias = 0;
    if (isNaN(item_ias))
      item_ias = 0;
  }
  else
  {
    document.write("<tr class=\"header\"><td align=\"center\"><b>"+OD_IAS);
    item_ias = 0;
  }

  document.write("</b></td><td align=\"center\"><b>"+OD_FPS+"</b></td><td align=\"center\"><b>"+OD_FREQ+"</b></td></tr>");

  lastFps = 100;
  while  (((isWIAS) && (r_ias <= 120)) || ((!isWIAS) && (capped < 1) && (item_ias <= 5000)))
  {
    //------------ calculate fps -------------//
    var fps = calculateFps(uchar, skill, r_weapon, l_weapon, item_ias, r_ias, l_ias, skill_ias, h2h, opener.weaponlist);

    if (isNaN(fps))
      capped = 1;

    if (fps < lastFps)
    {
      if (isWIAS)
        document.write("<tr class=\"two\"><td class=\"one\" align=\"center\">"+r_ias);
      else
        document.write("<tr class=\"two\"><td class=\"one\" align=\"center\">"+item_ias);

      document.write(" %</td><td align=\"center\">"+fps+"</td>");
      document.write("<td align=\"center\">"+round(25/fps, 1)+"</td></tr>");
      lastFps = fps;
    }
    if (isWIAS)
      r_ias++;
    else
      item_ias++;
  }
  document.write("</table>");
}

var SD_act1_standard    = [-10,-6,0,8,16,25,37,50,67];
var SD_act5_standard    = [-20,-19,-15,-10,-5,0,8,15,24,34,46,61];
var SD_act2_jab         = [-20,-17,-12,-6,0,8,17,28,42,56,75];
var SD_dragontail       = [-10,-7,-5,-3,0,3,6,9,13,17,22,27,33,40,49,59,71,85,103];
var SD_clawcharge_2H    = [-10,-8,-5,-3,0,4,7,11,15,20,25,30,38,45,54,64,76,91];
var SD_clawcharge_1H    = [-10,-9,-6,-3,1,5,11,16,23,30,40,51,64,80,102];
var SD_clawslash_left   = [-10,-7,-1,6,14,24,35,49,65];
var SD_clawthrust_right = [-10,-7,-1,6,14,24,35,49,65];
var SD_clawslash_right  = [-10,-9,-2,5,13,24,36,51,70];
var SD_fend_spear       = [-22,-12,0,17,40,75];
var SD_fend_jav         = [-25,-14,0,20,50];
var SD_chainlightning   = [-19,-17,-16,-14,-13,-11,-9,-7,-5,-3,0,3,6,9,12,16,20,25,29,35,42,48,56,65,76,88,103];
var SD_doublethrow      = [-17,-15,-12,-9,-6,-3,2,5,11,16,23,30,40,51,64,80,102];
var SD_doubleswing      = [-13,-6,3,11,22,35,51];
var SD_jab              = [-18,-16,-13,-11,-9,-6,-3,1,4,9,13,18,24,30,38,47,58,71,86,105];
var SD_frenzybp         = [-18,-16,-14,-12,-11,-9,-6,-4,-1,2,5,8,12,16,20,25,30,37,44,52,61,72,85,101];
var SD_werwolf          = [20,28,35,40,45,48,51,53,56,57,59,61,62,63,64,66,66,67,68,68,69,70,70,71,71,72,73,73,73,73];
// Changed by Tub: new (lower) BoS-boni in 1.10
//var SD_burstofspeed   = [0,23,29,34,39,42,45,47,49,51,52,54,55,56,57,57,59,59,60,60,61,61,62,62,63,63,63,64,64,65,65];
var SD_burstofspeed     = [0,21,27,31,34,37,39,41,42,44,45,46,47,48,49,50,51,51,51,52,52,53,53,54,54,54,55,55,55,55,55];
var SD_frenzy           = [0,7,13,18,22,25,27,29,31,33,34,35,36,37,38,39,40,40,41,41,42,42,43,43,44,44,44,45,45,45,45,46,46,46,46,46,47,47,47,47,47];

/*
  0 = amazon
  1 = barbarian
  2 = necromancer
  3 = paladin
  4 = sorceress
  5 = druid - normal
  6 = druid - werewolf
  7 = druid - werebear
  8 = assassin - normal
  9 = assassin - 1 claw
  10 = assassin - 2 claw
  11 = assassin - claw of thunder
*/[19,21,23,17,16,20];
var baseframes = [
[13,15,18,14,17,20,19,19,14], // 1H slash
[12,15,18,16,16,20,19,19,14], // 1H thrust
[17,17,22,17,21,21,21,21,22], // 2H sword
[15,18,23,19,20,23,23,23,22], // 2H thrust
[17,18,19,17,15,17,17,17,18], // 2H else
[13,14,17,15,16,15,16,16,15], // bow
[19,19,19,19,19,19,20,20,20], // crossbow
[15,15,19,15,19,17,19,19,14], // throw
[Number.NaN,Number.NaN,Number.NaN,Number.NaN,Number.NaN,Number.NaN,Number.NaN,Number.NaN,13,13,18,24] // claw
];

/*
name, speed, type, mercenary
 type 1 = 1H slash
      2 = 1H thrust
      3 = 2H sword
      4 = 2H thrust
      5 = 2H else
      6 = bow
      7 = crossbow
      8 = throw
      9 = claw
*/
var weaponlist = [
["-",0,1,0,"-",-1],
["Ancient Axe",10,5,0,"古代之斧",-1],
["Ancient Sword",0,1,3,"古代之剑",-1],
["Arbalest",-10,7,0,"石弓",-1],
["Archon Staff",10,5,0,"执政官之杖",-1],
["Ashwood Bow",0,6,0,"灰木之弓",0],
["Ataghan",-20,1,3,"土耳其剑",-1],
["Axe",10,1,0,"斧",-1],
["Balanced Axe",-10,8,0,"平衡斧",-1],
["Balanced Knife",-20,8,0,"平衡小刀",-1],
["Balista",10,7,0,"弩弓",-1],
["Balrog Blade",0,3,3,"炎魔之刃",-1],
["Balrog Spear",10,8,2,"炎魔长矛",-1],
["Barbed Club",0,1,0,"倒钩槌",-1],
["Bardiche",10,5,2,"大砍刀",-1],
["Bastard Sword",10,3,3,"巨剑",-1],
["Battle Axe",10,5,0,"战斗斧",-1],
["Battle Cestus",-10,9,0,"斗腰刀",6],
["Battle Dart",0,8,0,"战斗飞镖",-1],
["Battle Hammer",20,1,0,"战斗铁槌",-1],
["Battle Scythe",-10,5,2,"战斗镰刀",-1],
["Battle Staff",0,5,0,"战斗法杖",-1],
["Battle Sword",0,1,3,"战斗剑",-1],
["Bearded Axe",0,5,0,"钩斧",-1],
["Bec-de-Corbin",0,5,2,"双锋战戟",-1],
["Berserker Axe",0,1,0,"狂战士斧",-1],
["Bill",0,5,2,"比尔长刀",-1],
["Blade",-10,2,0,"短刀",-1],
["Blade Bow",-10,6,1,"刀锋弓",-1],
["Blade Talons",-20,9,0,"刃爪",6],
["Bone Knife",-20,2,0,"骸骨小刀",-1],
["Bone Wand",-20,1,0,"骨杖",-1],
["Brandistock",-20,4,2,"叉",-1],
["Broad Axe",0,5,0,"阔斧",-1],
["Broad Sword",0,1,3,"阔剑",-1],
["Burnt Wand",0,1,0,"烧焦之杖",-1],
["Caduceus",-10,1,0,"神使之杖",-1],
["Cedar Bow",0,6,1,"杉木弓",-1],
["Cedar Staff",10,5,0,"杉木之棍",-1],
["Ceremonial Bow",10,6,0,"祭典之弓",0],
["Ceremonial Javelin",-10,8,0,"祭典标枪",0],
["Ceremonial Pike",20,4,0,"祭典长矛",0],
["Ceremonial Spear",0,4,0,"祭典之矛",0],
["Cestus",0,9,0,"腰刀",6],
["Champion Axe",-10,5,0,"豪杰斧",-1],
["Champion Sword",-10,3,3,"冠军之剑",-1],
["Chu-Ko-Nu",-60,7,0,"巧工弩",-1],
["Cinquedeas",-20,2,0,"强波刀",-1],
["Clasped Orb",0,1,0,"握扣法珠",4],
["Claws",-10,9,0,"爪",6],
["Claymore",10,3,3,"双刃大刀",-1],
["Cleaver",10,1,0,"切肉斧",-1],
["Cloudy Sphere",0,1,0,"云雾之球",4],
["Club",-10,1,0,"木棒",-1],
["Colossus Sword",10,3,3,"巨神之剑",-1],
["Colossus Blade",5,3,3,"巨神之刃",-1],
["Colossus Crossbow",10,7,0,"巨神十字弓",-1],
["Colossus Voulge",10,5,2,"巨神之斧",-1],
["Composite Bow",-10,6,1,"组合弓",-1],
["Conquest Sword",0,1,3,"征服之剑",-1],
["Crossbow",0,7,0,"十字弓",-1],
["Crowbill",-10,1,0,"喙钳",-1],
["Crusader Bow",10,6,1,"十字军之弓",-1],
["Cryptic Axe",10,5,2,"神秘之斧",-1],
["Cryptic Sword",-10,1,3,"神秘之剑",-1],
["Crystal Sword",0,1,3,"水晶剑",-1],
["Crystalline Globe",-10,1,0,"水晶天球",4],
["Cudgel",-10,1,0,"棍棒",-1],
["Cutlass",-30,1,3,"微弯剑",-1],
["Dacian Falx",10,3,3,"双刃大刀",-1],
["Dagger",-20,2,0,"匕首",-1],
["Decapitator",10,5,0,"斩首斧",-1],
["Demon Crossbow",-60,7,0,"恶魔十字弓",-1],
["Demon Heart",0,1,0,"恶魔之心",4],
["Devil Star",10,1,0,"恶魔流星锤",-1],
["Diamond Bow",0,6,1,"钻石弓",-1],
["Dimensional Blade",0,1,3,"空间之刃",-1],
["Dimensional Shard",10,1,0,"次元碎片",4],
["Dirk",0,2,0,"长匕首",-1],
["Divine Scepter",-10,1,0,"神属权杖",-1],
["Double Axe",10,1,0,"双刃斧",-1],
["Double Bow",-10,6,1,"双弓",-1],
["Eagle Orb",-10,1,0,"鹰之法珠",4],
["Edge Bow",5,6,1,"锋锐之弓",-1],
["Elder Staff",0,5,0,"长老之杖",-1],
["Eldritch Orb",-10,1,0,"怪异之球",4],
["Elegant Blade",-10,1,3,"优雅之剑",-1],
["Espandon",0,3,3,"斩铁剑",-1],
["Ettin Axe",10,1,0,"双头斧",-1],
["Executioner Sword",10,3,3,"死刑之剑",-1],
["Falcata",0,1,3,"短剑",-1],
["Falchion",20,1,3,"弯形大刀",-1],
["Fanged Knife",-20,2,0,"齿缘小刀",-1],
["Fascia",10,9,0,"格斗爪",6],
["Feral Axe",-15,5,0,"猛禽斧",-1],
["Feral Claws",-20,9,0,"猛禽爪",6],
["Flail",-10,1,0,"链枷",-1],
["Flamberge",-10,3,3,"双手饰剑",-1],
["Flanged Mace",0,1,0,"凸缘钉头锤",-1],
["Flying Axe",10,8,0,"飞斧",-1],
["Flying Knife",0,8,0,"飞刀",-1],
["Francisca",10,8,0,"法兰飞斧",-1],
["Fuscina",0,4,2,"魔鬼之叉",-1],
["Ghost Glaive",20,8,2,"鬼魂尖枪",-1],
["Ghost Spear",0,4,2,"鬼魂之矛",-1],
["Ghost Wand",10,1,0,"鬼魂之杖",-1],
["Giant Axe",10,5,0,"大斧",-1],
["Giant Sword",0,3,3,"大剑",-1],
["Giant Thresher",-10,5,2,"鲛尾巨斧",-1],
["Gladius",0,1,3,"罗马短剑",-1],
["Glaive",20,8,2,"大长刀",-1],
["Glorious Axe",10,5,0,"荣光之斧",-1],
["Glowing Orb",-10,1,0,"灵光法珠",4],
["Gnarled Staff",10,5,0,"多节棍",-1],
["Gorgon Crossbow",0,7,0,"蛇魔女十字弓",-1],
["Gothic Axe",-10,5,0,"哥德之斧",-1],
["Gothic Bow",10,6,1,"哥德弓",-1],
["Gothic Staff",0,5,0,"哥德之棍",-1],
["Gothic Sword",10,3,3,"哥德剑",-1],
["Grand Matron Bow",10,6,0,"大院长之弓",0],
["Grand Scepter",10,1,0,"雄伟权杖",-1],
["Grave Wand",0,1,0,"墓地之杖",-1],
["Great Axe",-10,5,0,"卓越之斧",-1],
["Great Bow",-10,6,1,"巨弓",-1],
["Great Maul",20,5,0,"卓越巨棍",-1],
["Great Pilum",0,8,2,"卓越标枪",-1],
["Great Poleaxe",0,5,2,"巨长斧",-1],
["Great Sword",10,3,3,"卓越之剑",-1],
["Greater Claws",-20,9,0,"巨爪",6],
["Greater Talons",-30,9,0,"巨鹰爪",6],
["Grim Scythe",-10,5,2,"残酷镰刀",-1],
["Grim Wand",0,1,0,"残酷之杖",-1],
["Halberd",0,5,2,"长戟",-1],
["Hand Axe",0,1,0,"手斧",-1],
["Hand Scythe",-10,9,0,"手镰",6],
["Harpoon",-10,8,2,"鱼叉",-1],
["Hatchet",0,1,0,"小斧",-1],
["Hatchet Hands",10,9,0,"斧手",6],
["Heavenly Stone",-10,1,0,"天堂之石",4],
["Heavy Crossbow",10,7,0,"重十字弓",-1],
["Highland Blade",-5,3,3,"高地之剑",-1],
["Holy Water Sprinkler",10,1,0,"圣水喷杖",-1],
["Hunter's Bow",-10,6,1,"猎弓",-1],
["Hurlbat",-10,8,0,"短战戟",-1],
["Hydra Bow",10,6,1,"九头蛇弓",-1],
["Hydra Edge",10,1,3,"九头蛇刃",-1],
["Hyperion Javelin",-10,8,2,"亥伯龙之枪",-1],
["Hyperion Spear",-10,4,2,"亥伯龙之矛",-1],
["Jagged Star",10,1,0,"锯齿流星锤",-1],
["Jared's Stone",10,1,0,"杰瑞德之石",4],
["Javelin",-10,8,2,"标枪",-1],
["Jo Staff",-10,5,0,"乔木棒",-1],
["Katar",-10,9,0,"拳剑",6],
["Knout",-10,1,0,"铁皮鞭",-1],
["Kris",-20,2,0,"波形刀",-1],
["Lance",20,4,2,"长枪",-1],
["Large Axe",-10,5,0,"巨斧",-1],
["Large Siege Bow",10,6,1,"长攻城弓",-1],
["Legend Spike",-10,2,0,"传说尖刺",-1],
["Legend Sword",-15,3,3,"传说之剑",-1],
["Legendary Mallet",20,1,0,"传说之锤",-1],
["Lich Wand",-20,1,0,"巫妖法杖",-1],
["Light Crossbow",-10,7,0,"轻十字弓",-1],
["Lochaber Axe",10,5,2,"罗佳伯斧",-1],
["Long Battle Bow",10,6,1,"长战斗弓",-1],
["Long Bow",0,6,1,"长弓",-1],
["Long Staff",0,5,0,"长棍",-1],
["Long Sword",-10,1,3,"长剑",-1],
["Long War Bow",10,6,1,"长巨战弓",-1],
["Mace",0,1,0,"钉头锤",-1],
["Maiden Javelin",-10,8,0,"女士标枪",0],
["Maiden Pike",10,4,0,"女士长矛",0],
["Maiden Spear",0,4,0,"女士之矛",0],
["Mancatcher",-20,4,2,"刺人枪",-1],
["Martel de Fer",20,5,0,"战槌",-1],
["Matriarchal Bow",-10,6,0,"女族长之弓",0],
["Matriarchal Javelin",-10,8,0,"女族长之标枪",0],
["Matriarchal Pike",20,4,0,"女族长之长矛",0],
["Matriarchal Spear",0,4,0,"女族长之矛",0],
["Maul",10,5,0,"大木棍",-1],
["Mighty Scepter",0,1,0,"强威权杖",-1],
["Military Axe",-10,5,0,"军斧",-1],
["Military Pick",-10,1,0,"军用锹",-1],
["Mithril Point",0,2,0,"秘银小刀",-1],
["Morning Star",10,1,0,"流星锤",-1],
["Mythical Sword",0,1,3,"秘仪之剑",-1],
["Naga",0,1,0,"纳卡",-1],
["Ogre Axe",0,5,2,"食人魔之斧",-1],
["Ogre Maul",10,5,0,"食人魔之锤",-1],
["Partizan",10,5,2,"战戟",-1],
["Pellet Bow",-10,7,0,"弹丸弓",-1],
["Petrified Wand",10,1,0,"净化之杖",-1],
["Phase Blade",-30,1,3,"幻化之刃",-1],
["Pike",20,4,2,"矛",-1],
["Pilum",0,8,2,"短标枪",-1],
["Poignard",-20,2,0,"锐匕",-1],
["Poleaxe",10,5,2,"长柄战斧",-1],
["Polished Wand",0,1,0,"洗练法杖",-1],
["Quarter staff",0,5,0,"六尺棍",-1],
["Quhab",0,9,0,"格斗刃",6],
["Razor Bow",-10,6,1,"剃刀之弓",-1],
["Reflex Bow",10,6,0,"反射之弓",0],
["Reinforced Mace",0,1,0,"强化钉头锤",-1],
["Repeating Crossbow",-40,7,0,"连射十字弓",-1],
["Rondel",0,2,0,"诗歌匕首",-1],
["Rune Bow",0,6,1,"符文之弓",-1],
["Rune Scepter",0,1,0,"符文权杖",-1],
["Rune Staff",20,5,0,"符文之棍",-1],
["Rune Sword",-10,1,3,"符文剑",-1],
["Runic Talons",-30,9,0,"符纹爪",6],
["Sabre",-10,1,3,"军刀",-1],
["Sacred Globe",-10,1,0,"神圣天球",4],
["Scepter",0,1,0,"权杖",-1],
["Scimitar",-20,1,3,"弯刀",-1],
["Scissors Katar",-10,9,0,"剪咬刀",6],
["Scissors Quhab",0,9,0,"格斗剪",6],
["Scissors Suwayyah",0,9,0,"近身剪",6],
["Scourge",-10,1,0,"天罚之锤",-1],
["Scythe",-10,5,2,"镰刀",-1],
["Seraph Rod",10,1,0,"炽天使法杖",-1],
["Shadow Bow",0,6,1,"阴影弓",-1],
["Shamshir",-10,1,3,"虚伪之刃",-1],
["Shillelagh",0,5,0,"树皮之杖",-1],
["Short Battle Bow",0,6,1,"短战斗弓",-1],
["Short Bow",5,6,1,"短弓",-1],
["Short Siege Bow",0,6,1,"短攻城弓",-1],
["Short Spear",10,8,2,"短矛",-1],
["Short Staff",-10,5,0,"短棍",-1],
["Short Sword",0,1,3,"短剑",-1],
["Short War Bow",0,6,1,"短巨战弓",-1],
["Siege Crossbow",0,7,0,"攻城十字弓",-1],
["Silver Edged Axe",0,5,0,"银刃斧",-1],
["Simbilan",10,8,2,"锐矛",-1],
["Small Crescent",10,1,0,"弯月斧",-1],
["Smoked Sphere",0,1,0,"撒烟之球",4],
["Sparkling Ball",0,1,0,"闪耀之珠",4],
["Spear",-10,4,2,"长矛",-1],
["Spetum",0,4,2,"大战戟",-1],
["Spiculum",20,8,2,"阔针长矛",-1],
["Spider Bow",5,6,1,"蜘蛛弓",-1],
["Spiked Club",0,1,0,"狼牙棒",-1],
["Stag Bow",0,6,0,"男性之弓",0],
["Stalagmite",10,5,0,"钟乳石之杖",-1],
["Stiletto",-10,2,0,"小剑",-1],
["Stygian Pike",0,4,2,"冥河之枪",-1],
["Stygian Pilum",0,8,2,"冥河标枪",-1],
["Suwayyah",0,9,0,"近身刃",6],
["Swirling Crystal",10,1,0,"涡流水晶",4],
["Tabar",10,5,0,"战斗斧",-1],
["Thresher",-10,5,2,"锐利之斧",-1],
["Throwing Axe",10,8,0,"飞斧",-1],
["Throwing Knife",0,8,0,"飞刀",-1],
["Throwing Spear",-10,8,2,"飞矛",-1],
["Thunder Maul",20,5,0,"雷锤",-1],
["Tomahawk",0,1,0,"战铖",-1],
["Tomb Wand",-20,1,0,"古墓之杖",-1],
["Trident",0,4,2,"三叉戟",-1],
["Truncheon",-10,1,0,"战仪杖",-1],
["Tulwar",20,1,3,"圆月弯刀",-1],
["Tusk Sword",0,3,3,"长牙剑",-1],
["Twin Axe",10,1,0,"强化双斧",-1],
["Two-Handed Sword",0,3,3,"双手剑",-1],
["Tyrant Club",0,1,0,"暴君之棒",-1],
["Unearthed Wand",0,1,0,"破隐法杖",-1],
["Vortex Orb",0,1,0,"漩涡球",4],
["Voulge",0,5,2,"钩镰枪",-1],
["Walking Stick",-10,5,0,"手杖",-1],
["Wand",0,1,0,"法杖",-1],
["War Axe",0,1,0,"巨战斧",-1],
["War Club",10,5,0,"巨战木棍",-1],
["War Dart",-20,8,0,"巨战飞镖",-1],
["War Fist",10,9,0,"战拳",6],
["War Fork",-20,4,2,"巨战之叉",-1],
["War Hammer",20,1,0,"巨战铁槌",-1],
["War Javelin",-10,8,2,"巨战标枪",-1],
["War Pike",20,4,2,"战枪",-1],
["War Scepter",-10,1,0,"巨战权杖",-1],
["War Scythe",-10,5,2,"巨战镰刀",-1],
["War Spear",-10,4,2,"巨战长矛",-1],
["War Spike",-10,1,0,"战刺",-1],
["War Staff",20,5,0,"巨战法杖",-1],
["War Sword",0,1,3,"巨战之剑",-1],
["Ward Bow",0,6,1,"庇护之弓",-1],
["Winged Axe",-10,8,0,"翼斧",-1],
["Winged Harpoon",-10,8,2,"翼鱼叉",-1],
["Winged Knife",-20,8,0,"翼刀",-1],
["Wrist Blade",0,9,0,"腕刀",6],
["Wrist Spike",-10,9,0,"腕刺",6],
["Wrist Sword",-10,9,0,"腕剑",6],
["Yari",0,4,2,"三叉长枪",-1],
["Yew Wand",10,1,0,"紫杉之杖",-1],
["Zweihander",-10,3,3,"瑞韩德之剑",-1]
]


setCharValues(document.forms.theForm);



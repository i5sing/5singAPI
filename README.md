# 5singAPI
已废弃，请使用原生API https://github.com/i5sing/5sing-mobile-api 

## Usage
##### header
```javascript
content-type: 'application/json'
```

### [get]/api/songs

获取热门歌曲  

#### query
| key                | value                                         |      |
| -------------------|:---------------------------------------------:|:----:|
| type(歌曲类型)     | yc(原创) fc(翻唱) bz(伴奏)                    | 必须 |
| category(歌曲类别) | tj(推荐) hx(候选) zj(自荐) zx(最新) hot(热门) | 必须 |
| page(页数)         | 数字1-50                                      | 可选 |

####response
```json
{
  "code": "200",
  "message": "",
  "data": {
    "page": 2,
    "list": [
      {
        "id": "3000014",
        "name": "【雁引歌】天地神风鉴",
        "author": "平纱落雁音乐团队",
        "style": "",
        "clickNumber": 1471275,
        "likeNumber": 179,
        "downNumber": 0,
        "lrcs": "",
        "introduction": "",
        "address": ""
      }
    ]
  }
}
```

### [get]/api/songs/:songId

获取歌曲详情  

#### query
| key                | value                                         |      |
| -------------------|:---------------------------------------------:|:----:|
| type(歌曲类型)     | yc(原创) fc(翻唱) bz(伴奏)                    | 必须 |
| page(页数)         | 数字1-50                                      | 可选 |

#### response
```json
{
  "code": "200",
  "message": "",
  "data": {
    "id": "3014194",
    "name": "烟灰",
    "author": "三亩地",
    "authorImg": "http://img5.5sing.kgimg.com/force/T1sK__Byxv1RXrhCrK_72_72.jpg",
    "style": "三亩地",
    "clickNumber": 499182,
    "likeNumber": 0,
    "downNumber": 0,
    "lrcs": "烟灰在夜空中飘散，而我已彻底的凌乱，因为又想起你的脸。 还记得单车后的你，像孩子一样的顽皮，那笑容如此的温暖。 穿过繁华落幕的街，独自一人再吃碗面，那味道已不如从前。 惊醒在每一个夜里，我知道已不属于你，就让这梦随风散去。 曾经每个夜里***疯狂，已经变成破碎不堪的幻象。 那些关于争吵对错的执着，已变成孤独后冰冷的呼吸。 不经意间，哭了，所有思念，已变成烈酒，在每个周末狂欢，醉了，依然心痛，在最后一 杯酒中我醒了。 遗忘在角落的相片，用他来点燃这诺言，这样才会好过点。 在没有你睡的房间，点燃一根事后烟，这感觉撕裂我胸膛。 临界在疯狂的边缘，我用力摔碎这思念，让情绪全部发泄。 沉默的我如同死去，在这寂寞的世界里，让我最后一次再爱你。 那些错与对的全部都抛开，让我们享受进入一瞬间。 让这爱与恨全部到达顶点，在这永恒的绝望里回不来。 在爱的顶点，哭了，所有欲望，混合味道，在冰冷的空气里，散了，就这样别了，在最后 的一次疯狂中。",
    "introduction": "烟灭了",
    "address": "http://data.5sing.kgimg.com/G051/M09/10/1F/04YBAFafJ7OAfPUNAFPj09Dp9pk347.m4a",
    "uploadTime": ""
  }
}
```

### [get]/api/musicians

获取热门音乐人

#### query
| key                | value                                         |      |
| -------------------|:---------------------------------------------:|:----:|
| page(页数)         | 数字1-50                                      | 可选 |

#### response
```json
{
  "code": "200",
  "message": "",
  "data": {
    "page": 1,
    "list": [
      {
        "imgAddress": "http://img9.5sing.kgimg.com/force/T1mkd0BybT1RXrhCrK_75_75.jpg",
        "name": "NOVO乐队",
        "id": "54228108",
        "introduction": ""
      }
    ]
  }
}
```

### [get]/api/songs/space/:userId

获取音乐人歌曲

#### query
| key                | value                                         |      |
| -------------------|:---------------------------------------------:|:----:|
| type(歌曲类型)     | yc(原创) fc(翻唱) bz(伴奏)                    | 必须 |
| page(页数)         | 数字1-50                                      | 可选 |

#### response
```json
{
  "code": "200",
  "message": "",
  "data": {
    "page": 0,
    "list": [
      {
        "id": "",
        "name": "时光约定【暖暖同人歌】",
        "author": "",
        "authorImg": "",
        "style": "",
        "clickNumber": 9563022,
        "likeNumber": 0,
        "downNumber": 0,
        "lrcs": "",
        "introduction": "",
        "address": "",
        "uploadTime": "2014-12-20"
      }
    ]
  }
}
```

### [get]/api/musicians/space/:userId

获取音乐人粉丝

#### query
| key                | value                                         |      |
| -------------------|:---------------------------------------------:|:----:|
| page(页数)         | 数字1-50                                      | 可选 |

#### response
```json
{
  "code": "200",
  "message": "",
  "data": {
    "page": 0,
    "list": [
      {
        "imgAddress": "http://static.5sing.kugou.com/images/nan_48.jpg",
        "name": "3WT2AHT508",
        "id": "54574939",
        "introduction": "TA还没有添加简介"
      }
    ]
  }
}
```

### [post]/api/search

搜索

#### body
| key                | value                                         |      |
| -------------------|:---------------------------------------------:|:----:|
| type               | yc(原创) fc(翻唱) bz(伴奏) user(会员)           | 可选 |
| key                | 搜索关键字                                     | 可选 |
| page(页数)         | 数字1-50                                       | 可选 |

#### response
```json
//songs
{
  "code": "200",
  "message": "",
  "data": {
    "page": 1,
    "list": [
      {
        "id": "2493529",
        "name": "《14forever》",
        "author": "陈美伊",
        "authorImg": "",
        "style": "",
        "clickNumber": 0,
        "likeNumber": 0,
        "downNumber": 0,
        "lrcs": "",
        "introduction": "",
        "address": "",
        "uploadTime": ""
      }
    ]
  }
}

//users
{
  "code": "200",
  "message": "",
  "data": {
    "page": 1,
    "list": [
      {
        "imgAddress": "",
        "name": "可心小屋",
        "id": "8888383",
        "introduction": "我是一个热爱音乐的女孩，1999年2月出生，2010年7月开始课余进行声乐训练。几年来，我陆续录制了..."
      }
    ]
  }
}
```

## Demo

http://139.129.24.142:8080/5sing/

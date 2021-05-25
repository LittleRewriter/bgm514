package com.lire.netdatahandler

import com.google.gson.JsonParser
import com.lire.subject.Chara
import com.lire.subject.Staff
import com.lire.subject.SubjectInfo
import com.lire.subject.TypeOfSubject

val subjectStr = """
{
    "id": 12,
    "url": "http:\/\/bgm.tv\/subject\/12",
    "type": 2,
    "name": "\u3061\u3087\u3073\u3063\u30c4",
    "name_cn": "\u4eba\u5f62\u7535\u8111\u5929\u4f7f\u5fc3",
    "summary": "\u5728\u4e0d\u4e45\u7684\u5c06\u6765,\u7535\u5b50\u6280\u672f\u98de\u901f\u53d1\u5c55,\u7535\u8111\u6210\u4e3a\u4eba\u4eec\u751f\u6d3b\u4e2d\u4e0d\u53ef\u7f3a\u5c11\u7684\u4e00\u90e8\u5206.\u4e3b\u89d2\u7684\u540d\u5b57\u662f\u672c\u987b\u548c\u79c0\u6811,\u662f\u4e2a19\u5c81\u7684\u5c11\u5e74,\u7531\u4e8e\u8003\u8bd5\u5931\u8d25,\u6765\u5230\u4e1c\u4eac\u4e0a\u8865\u4e60\u73ed,\u8fc7\u7740\u8d2b\u7a77\u6f66\u5012\u7684\u751f\u6d3b\u2026\u2026\r\n\u5230\u8fbe\u4e1c\u4eac\u7684\u7b2c\u4e00\u5929,\u4ed6\u5f88\u5e78\u8fd0\u7684\u5728\u5783\u573e\u5806\u6361\u5230\u4e00\u4e2a\u4eba\u578b\u7535\u8111,\u4e00\u76f4\u4ee5\u6765\u79c0\u6811\u90fd\u975e\u5e38\u6e34\u671b\u62e5\u6709\u4e2a\u4eba\u7535\u8111.\u5f53\u4ed6\u62b1\u7740\u5979\u5e26\u8fd4\u516c\u5bd3\u540e,\u5374\u4e0d\u77e5\u5982\u4f55\u5f00\u673a,\u5728\u610f\u60f3\u4e0d\u5230\u7684\u5730\u65b9\u627e\u5230\u5f00\u5173\u5e76\u5f00\u542f\u540e,\u6545\u4e8b\u5c31\u6b64\u5c55\u5f00\r\n\u672c\u987b\u548c\u79c0\u6811\u6361\u5230\u4e86\u4eba\u578b\u8ba1\u7b97\u673a\u3014\u5527\u3015\u3002\u867d\u7136\u4e0d\u6653\u5f97\u5979\u5230\u5e95\u662f\u4e0d\u662f\u3014Chobits\u3015\uff0c\u4f46\u5979\u7684\u8eab\u4e0a\u4f3c\u4e4e\u85cf\u6709\u6781\u5927\u7684\u79d8\u5bc6\u3002\u770b\u5230\u79c0\u6811\u4e3a\u4e86\u94b1\u800c\u70e6\u607c\uff0c\u5527\u51fa\u53bb\u627e\u6253\u5de5\uff0c\u6ca1\u60f3\u5230\u5374\u627e\u5230\u4e86\u5371\u9669\u7684\u5de5\u4f5c\uff01\u4e3a\u4e86\u8ba9\u79c0\u6811\u5f00\u5fc3\uff0c\u5527\u5f00\u59cb\u5230\u8272\u60c5\u5c0f\u5c4b\u6253\u5de5\u3002\u4f46\u5979\u5728\u906d\u5230\u8fc7\u5ea6\u6fc0\u70c8\u7684\u5f3a\u8feb\u8981\u6c42\u4e4b\u540e\u5931\u63a7\u3002\u8ba9\u5468\u906d\u8ba1\u7b97\u673a\u56e0\u6b64\u800c\u5f3a\u5236\u505c\u6446\u3002\r\n\u53e6\u4e00\u65b9\u9762\uff0c\u79c0\u6811\u53d1\u73b0\u597d\u53cb\u65b0\u4fdd\u4e0e\u8865\u4e60\u73ed\u7684\u6e05\u6c34\u8001\u5e08\u6709\u7740\u4e0d\u53ef\u544a\u4eba\u7684\u5173\u7cfb\u2026\u2026",
    "eps": 27,
    "eps_count": 27,
    "air_date": "2002-04-02",
    "air_weekday": 2,
    "rating": {
        "total": 3088,
        "count": {
            "10": 161,
            "9": 356,
            "8": 1169,
            "7": 948,
            "6": 372,
            "5": 56,
            "4": 13,
            "3": 5,
            "2": 4,
            "1": 4
        },
        "score": 7.6
    },
    "rank": 688,
    "images": {
        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/c2\/0a\/12_aDoa8.jpg",
        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/c2\/0a\/12_aDoa8.jpg",
        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/c2\/0a\/12_aDoa8.jpg",
        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/c2\/0a\/12_aDoa8.jpg",
        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/c2\/0a\/12_aDoa8.jpg"
    },
    "collection": {
        "wish": 1047,
        "collect": 4286,
        "doing": 183,
        "on_hold": 444,
        "dropped": 126
    },
    "crt": [
        {
            "id": 32,
            "url": "http:\/\/bgm.tv\/character\/32",
            "name": "\u3061\u3043",
            "name_cn": "\u5c0f\u53fd",
            "role_name": "\u4e3b\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/ce\/65\/32_crt_0g9f9.jpg?r=1606033650",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/ce\/65\/32_crt_0g9f9.jpg?r=1606033650",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/ce\/65\/32_crt_0g9f9.jpg?r=1606033650",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/ce\/65\/32_crt_0g9f9.jpg?r=1606033650"
            },
            "comment": 44,
            "collects": 240,
            "info": {
                "birth": "4\u670813\u65e5",
                "height": "152cm",
                "gender": "\u5973",
                "alias": {
                    "jp": "\u3061\u3043",
                    "romaji": "chii",
                    "zh": "\u5c0f\u5527"
                },
                "source": [
                    "anidb.net"
                ],
                "name_cn": "\u5c0f\u53fd",
                "cv": "\u7530\u4e2d\u7406\u60e0"
            },
            "actors": [
                {
                    "id": 3862,
                    "url": "http:\/\/bgm.tv\/person\/3862",
                    "name": "\u7530\u4e2d\u7406\u6075",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/59\/da\/3862_prsn_n2373.jpg?r=1591801349",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/59\/da\/3862_prsn_n2373.jpg?r=1591801349",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/59\/da\/3862_prsn_n2373.jpg?r=1591801349",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/59\/da\/3862_prsn_n2373.jpg?r=1591801349"
                    }
                }
            ]
        },
        {
            "id": 33,
            "url": "http:\/\/bgm.tv\/character\/33",
            "name": "\u672c\u9808\u548c\u79c0\u6a39",
            "name_cn": "\u672c\u987b\u548c\u79c0\u6811",
            "role_name": "\u4e3b\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/18\/2b\/33_0c5cdcd5072bb1864cdee4d3d6e_yyZGp.jpg",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/18\/2b\/33_0c5cdcd5072bb1864cdee4d3d6e_yyZGp.jpg",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/18\/2b\/33_0c5cdcd5072bb1864cdee4d3d6e_yyZGp.jpg",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/18\/2b\/33_0c5cdcd5072bb1864cdee4d3d6e_yyZGp.jpg"
            },
            "comment": 4,
            "collects": 10,
            "info": {
                "name_cn": "\u672c\u987b\u548c\u79c0\u6811",
                "alias": {
                    "jp": "\u672c\u9808\u548c \u79c0\u6a39"
                },
                "gender": "\u7537",
                "birth": "9\u67083\u65e5",
                "height": "180cm"
            },
            "actors": [
                {
                    "id": 4513,
                    "url": "http:\/\/bgm.tv\/person\/4513",
                    "name": "\u6749\u7530\u667a\u548c",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/72\/98\/4513_prsn_6HNa0.jpg?r=1507271945",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/72\/98\/4513_prsn_6HNa0.jpg?r=1507271945",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/72\/98\/4513_prsn_6HNa0.jpg?r=1507271945",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/72\/98\/4513_prsn_6HNa0.jpg?r=1507271945"
                    }
                }
            ]
        },
        {
            "id": 34,
            "url": "http:\/\/bgm.tv\/character\/34",
            "name": "\u3059\u3082\u3082",
            "name_cn": "\u4e1d\u8309\u8309",
            "role_name": "\u914d\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/a3\/a8\/34_crt_jjRra.jpg?r=1606034310",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/a3\/a8\/34_crt_jjRra.jpg?r=1606034310",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/a3\/a8\/34_crt_jjRra.jpg?r=1606034310",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/a3\/a8\/34_crt_jjRra.jpg?r=1606034310"
            },
            "comment": 6,
            "collects": 15,
            "info": {
                "birth": "1\u67081\u65e5",
                "height": "16cm",
                "gender": "\u672a\u77e5",
                "alias": {
                    "jp": "\u3059\u3082\u3082",
                    "romaji": "Sumomo"
                },
                "source": [
                    "anidb.net"
                ],
                "name_cn": "\u4e1d\u8309\u8309",
                "cv": "\u718a\u4e95\u7d20\u5b50"
            },
            "actors": [
                {
                    "id": 4056,
                    "url": "http:\/\/bgm.tv\/person\/4056",
                    "name": "\u304f\u307e\u3044\u3082\u3068\u3053",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/95\/29\/4056_seiyu_anidb.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/95\/29\/4056_seiyu_anidb.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/95\/29\/4056_seiyu_anidb.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/95\/29\/4056_seiyu_anidb.jpg"
                    }
                }
            ]
        },
        {
            "id": 35,
            "url": "http:\/\/bgm.tv\/character\/35",
            "name": "\u65b0\u4fdd\u5f18",
            "name_cn": "\u65b0\u4fdd\u5f18",
            "role_name": "\u914d\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/1c\/38\/35_cd30b7c298ab50293adfecb7b18_XBFDY.jpg",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/1c\/38\/35_cd30b7c298ab50293adfecb7b18_XBFDY.jpg",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/1c\/38\/35_cd30b7c298ab50293adfecb7b18_XBFDY.jpg",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/1c\/38\/35_cd30b7c298ab50293adfecb7b18_XBFDY.jpg"
            },
            "comment": 1,
            "collects": 3,
            "info": {
                "name_cn": "\u65b0\u4fdd\u5f18",
                "alias": {
                    "jp": "\u65b0\u4fdd \u5f18",
                    "romaji": "Shinbo Hiromu"
                },
                "gender": "\u7537",
                "birth": "12\u670822\u65e5",
                "height": "180cm",
                "source": "anidb.net",
                "cv": "\u5173\u667a\u4e00"
            },
            "actors": [
                {
                    "id": 3868,
                    "url": "http:\/\/bgm.tv\/person\/3868",
                    "name": "\u95a2\u667a\u4e00",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/40\/94\/3868_prsn_24eU6.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/40\/94\/3868_prsn_24eU6.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/40\/94\/3868_prsn_24eU6.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/40\/94\/3868_prsn_24eU6.jpg"
                    }
                }
            ]
        },
        {
            "id": 36,
            "url": "http:\/\/bgm.tv\/character\/36",
            "name": "\u67da\u59ec",
            "name_cn": "",
            "role_name": "\u914d\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/90\/55\/36_crt_pWSn2.jpg?r=1606034534",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/90\/55\/36_crt_pWSn2.jpg?r=1606034534",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/90\/55\/36_crt_pWSn2.jpg?r=1606034534",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/90\/55\/36_crt_pWSn2.jpg?r=1606034534"
            },
            "comment": 3,
            "collects": 29,
            "info": {
                "gender": "\u5973",
                "birth": "12\u670825\u65e5",
                "height": "160cm"
            },
            "actors": [
                {
                    "id": 4042,
                    "url": "http:\/\/bgm.tv\/person\/4042",
                    "name": "\u6298\u7b20\u5bcc\u7f8e\u5b50",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/b9\/7a\/4042_prsn_7STfP.jpg?r=1551440412",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/b9\/7a\/4042_prsn_7STfP.jpg?r=1551440412",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/b9\/7a\/4042_prsn_7STfP.jpg?r=1551440412",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/b9\/7a\/4042_prsn_7STfP.jpg?r=1551440412"
                    }
                }
            ]
        },
        {
            "id": 37,
            "url": "http:\/\/bgm.tv\/character\/37",
            "name": "\u56fd\u5206\u5bfa\u7a14",
            "name_cn": "\u56fd\u5206\u5bfa\u7a14",
            "role_name": "\u914d\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/a5\/bf\/37_9e07964f8dddeb95fc584cd965d_QvIyo.jpg",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/a5\/bf\/37_9e07964f8dddeb95fc584cd965d_QvIyo.jpg",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/a5\/bf\/37_9e07964f8dddeb95fc584cd965d_QvIyo.jpg",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/a5\/bf\/37_9e07964f8dddeb95fc584cd965d_QvIyo.jpg"
            },
            "comment": 0,
            "collects": 6,
            "info": {
                "name_cn": "\u56fd\u5206\u5bfa\u7a14",
                "alias": {
                    "jp": "\u56fd\u5206\u5bfa \u7a14",
                    "romaji": "Kokubunji Minoru"
                },
                "gender": "\u672a\u77e5",
                "birth": "1\u670825\u65e5",
                "height": "145cm",
                "source": "anidb.net",
                "cv": "\u6851\u5c9b\u6cd5\u5b50"
            },
            "actors": [
                {
                    "id": 3867,
                    "url": "http:\/\/bgm.tv\/person\/3867",
                    "name": "\u6851\u5cf6\u6cd5\u5b50",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/70\/b9\/3867_prsn_b0qFF.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/70\/b9\/3867_prsn_b0qFF.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/70\/b9\/3867_prsn_b0qFF.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/70\/b9\/3867_prsn_b0qFF.jpg"
                    }
                }
            ]
        },
        {
            "id": 38,
            "url": "http:\/\/bgm.tv\/character\/38",
            "name": "\u65e5\u6bd4\u8c37\u5343\u6b72",
            "name_cn": "\u65e5\u6bd4\u8c37\u5343\u5c81",
            "role_name": "\u914d\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/a5\/77\/38_bce93e200c36f7cd9dfd0e5deaa_0gv2M.jpg?r=1394081009",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/a5\/77\/38_bce93e200c36f7cd9dfd0e5deaa_0gv2M.jpg?r=1394081009",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/a5\/77\/38_bce93e200c36f7cd9dfd0e5deaa_0gv2M.jpg?r=1394081009",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/a5\/77\/38_bce93e200c36f7cd9dfd0e5deaa_0gv2M.jpg?r=1394081009"
            },
            "comment": 6,
            "collects": 10,
            "info": {
                "name_cn": "\u65e5\u6bd4\u8c37\u5343\u5c81",
                "alias": {
                    "0": "\u307f\u306f\u3089\u3061\u3068\u305b",
                    "1": "Mihara Chitose",
                    "zh": "\u4e09\u539f\u5343\u5c81",
                    "jp": "\u65e5\u6bd4\u8c37 \u5343\u6b72",
                    "kana": "\u3072\u3073\u3084 \u3061\u3068\u305b",
                    "romaji": "Hibiya Chitose"
                },
                "gender": "\u5973",
                "birth": "9\u670824\u65e5",
                "height": "165cm",
                "cv": "\u4e95\u4e0a\u559c\u4e45\u5b50"
            },
            "actors": [
                {
                    "id": 3945,
                    "url": "http:\/\/bgm.tv\/person\/3945",
                    "name": "\u4e95\u4e0a\u559c\u4e45\u5b50",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/4c\/f5\/3945_prsn_zZ2FW.jpg?r=1447226859",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/4c\/f5\/3945_prsn_zZ2FW.jpg?r=1447226859",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/4c\/f5\/3945_prsn_zZ2FW.jpg?r=1447226859",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/4c\/f5\/3945_prsn_zZ2FW.jpg?r=1447226859"
                    }
                }
            ]
        },
        {
            "id": 39,
            "url": "http:\/\/bgm.tv\/character\/39",
            "name": "\u5927\u6751\u88d5\u7f8e",
            "name_cn": "\u5927\u6751\u88d5\u7f8e",
            "role_name": "\u914d\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/0a\/aa\/39_crt_RZZ94.jpg?r=1606033844",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/0a\/aa\/39_crt_RZZ94.jpg?r=1606033844",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/0a\/aa\/39_crt_RZZ94.jpg?r=1606033844",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/0a\/aa\/39_crt_RZZ94.jpg?r=1606033844"
            },
            "comment": 3,
            "collects": 3,
            "info": {
                "name_cn": "\u5927\u6751\u88d5\u7f8e",
                "alias": {
                    "jp": "\u5927\u6751 \u88d5\u7f8e",
                    "kana": "\u304a\u304a\u3080\u3089 \u3086\u307f",
                    "romaji": "Oomura Yumi"
                },
                "gender": "\u5973",
                "birth": "5\u670820\u65e5",
                "height": "150cm",
                "source": "anidb.net",
                "cv": "\u8c4a\u53e3\u3081\u3050\u307f"
            },
            "actors": [
                {
                    "id": 3866,
                    "url": "http:\/\/bgm.tv\/person\/3866",
                    "name": "\u8c4a\u53e3\u3081\u3050\u307f",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/7e\/e4\/3866_prsn_4miMW.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/7e\/e4\/3866_prsn_4miMW.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/7e\/e4\/3866_prsn_4miMW.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/7e\/e4\/3866_prsn_4miMW.jpg"
                    }
                }
            ]
        },
        {
            "id": 40,
            "url": "http:\/\/bgm.tv\/character\/40",
            "name": "\u6e05\u6c34\u591a\u9999\u5b50",
            "name_cn": "\u6e05\u6c34\u591a\u9999\u5b50",
            "role_name": "\u914d\u89d2",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/d6\/45\/40_20e395fedad7bbbed0eca3fe2e0_nRIwK.jpg",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/d6\/45\/40_20e395fedad7bbbed0eca3fe2e0_nRIwK.jpg",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/d6\/45\/40_20e395fedad7bbbed0eca3fe2e0_nRIwK.jpg",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/d6\/45\/40_20e395fedad7bbbed0eca3fe2e0_nRIwK.jpg"
            },
            "comment": 0,
            "collects": 6,
            "info": {
                "name_cn": "\u6e05\u6c34\u591a\u9999\u5b50",
                "alias": {
                    "jp": "\u6e05\u6c34 \u591a\u9999\u5b50"
                },
                "gender": "\u5973",
                "birth": "7\u670828\u65e5",
                "height": "167cm",
                "cv": "\u67da\u6728\u51c9\u9999"
            },
            "actors": [
                {
                    "id": 4007,
                    "url": "http:\/\/bgm.tv\/person\/4007",
                    "name": "\u67da\u6728\u6dbc\u9999",
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/4b\/11\/4007_prsn_Lcs6O.jpg?r=1581626156",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/4b\/11\/4007_prsn_Lcs6O.jpg?r=1581626156",
                        "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/4b\/11\/4007_prsn_Lcs6O.jpg?r=1581626156",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/4b\/11\/4007_prsn_Lcs6O.jpg?r=1581626156"
                    }
                }
            ]
        }
    ],
    "staff": [
        {
            "id": 39,
            "url": "http:\/\/bgm.tv\/person\/39",
            "name": "CLAMP",
            "name_cn": "",
            "role_name": "",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/d6\/7d\/39_prsn_anidb.jpg",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/d6\/7d\/39_prsn_anidb.jpg",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/d6\/7d\/39_prsn_anidb.jpg",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/d6\/7d\/39_prsn_anidb.jpg"
            },
            "comment": 52,
            "collects": 0,
            "info": {
                "alias": {
                    "jp": "\u30af\u30e9\u30f3\u30d7",
                    "0": "\u3044\u304c\u3089\u3057\u5bd2\u6708",
                    "1": "\u5927\u5ddd\u4e03\u702c",
                    "2": "\u732b\u4e95\u693f",
                    "3": "\u3082\u3053\u306a"
                }
            },
            "jobs": [
                "\u539f\u4f5c"
            ]
        },
        {
            "id": 40,
            "url": "http:\/\/bgm.tv\/person\/40",
            "name": "\u6d45\u9999\u5b88\u751f",
            "name_cn": "\u6d45\u9999\u5b88\u751f",
            "role_name": "",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/1e\/ef\/40_prsn_NnfCf.jpg?r=1409256270",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/1e\/ef\/40_prsn_NnfCf.jpg?r=1409256270",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/1e\/ef\/40_prsn_NnfCf.jpg?r=1409256270",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/1e\/ef\/40_prsn_NnfCf.jpg?r=1409256270"
            },
            "comment": 46,
            "collects": 0,
            "info": {
                "name_cn": "\u6d45\u9999\u5b88\u751f",
                "alias": {
                    "jp": "\u6d45\u9999\u5b88\u751f",
                    "kana": "\u3042\u3055\u304b \u3082\u308a\u304a",
                    "romaji": "Asaka Morio"
                },
                "gender": "\u7537",
                "birth": "1967-03-11"
            },
            "jobs": [
                "\u5bfc\u6f14"
            ]
        },
        {
            "id": 380,
            "url": "http:\/\/bgm.tv\/person\/380",
            "name": "\u5927\u5ddd\u4e03\u702c",
            "name_cn": "\u5927\u5ddd\u4e03\u6fd1",
            "role_name": "",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/bc\/a8\/380_prsn_anidb.jpg",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/bc\/a8\/380_prsn_anidb.jpg",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/bc\/a8\/380_prsn_anidb.jpg",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/bc\/a8\/380_prsn_anidb.jpg"
            },
            "comment": 5,
            "collects": 0,
            "info": {
                "name_cn": "\u5927\u5ddd\u4e03\u6fd1",
                "alias": {
                    "0": "Ookawa Ageha",
                    "1": "\u5927\u5ddd\u7dcb\u82ad",
                    "jp": "\u5927\u5ddd\u4e03\u702c",
                    "kana": "\u304a\u304a\u304b\u308f \u306a\u306a\u305b",
                    "romaji": "Ookawa Nanase"
                },
                "gender": "\u5973",
                "birth": "1967-05-02",
                "bloodtype": "A\u578b"
            },
            "jobs": [
                "\u811a\u672c"
            ]
        },
        {
            "id": 25981,
            "url": "http:\/\/bgm.tv\/person\/25981",
            "name": "\u91d1\u5b50\u4e8c\u90ce",
            "name_cn": "\u91d1\u5b50\u4e8c\u90ce",
            "role_name": "",
            "images": null,
            "comment": 0,
            "collects": 0,
            "info": {
                "name_cn": "\u91d1\u5b50\u4e8c\u90ce",
                "alias": {
                    "0": "\u91d1\u5b50\u5f26\u4e8c\u90ce",
                    "kana": "\u304b\u306d\u3053 \u3058\u308d\u3046"
                },
                "birth": "1962\u5e748\u670821\u65e5"
            },
            "jobs": [
                "\u811a\u672c"
            ]
        },
        {
            "id": 262,
            "url": "http:\/\/bgm.tv\/person\/262",
            "name": "\u82b1\u7530\u5341\u8f1d",
            "name_cn": "\u82b1\u7530\u5341\u8f89",
            "role_name": "",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/92\/18\/262_prsn_m9eh0.jpg?r=1523559113",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/92\/18\/262_prsn_m9eh0.jpg?r=1523559113",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/92\/18\/262_prsn_m9eh0.jpg?r=1523559113",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/92\/18\/262_prsn_m9eh0.jpg?r=1523559113"
            },
            "comment": 88,
            "collects": 0,
            "info": {
                "name_cn": "\u82b1\u7530\u5341\u8f89",
                "alias": {
                    "kana": "\u306f\u306a\u3060 \u3058\u3085\u3063\u304d",
                    "romaji": "Hanada Jukki"
                },
                "gender": "\u7537",
                "birth": "1969\u5e74",
                "Twitter": "@oitan125"
            },
            "jobs": [
                "\u811a\u672c"
            ]
        },
        {
            "id": 21,
            "url": "http:\/\/bgm.tv\/person\/21",
            "name": "\u5800\u4e95\u660e\u5b50",
            "name_cn": "\u5800\u4e95\u660e\u5b50",
            "role_name": "",
            "images": null,
            "comment": 0,
            "collects": 0,
            "info": {
                "name_cn": "\u5800\u4e95\u660e\u5b50",
                "alias": {
                    "jp": "\u5800\u4e95\u660e\u5b50",
                    "kana": "\u307b\u308a\u3044 \u3042\u304d\u3053",
                    "romaji": "Horii Akiko"
                },
                "gender": "\u5973"
            },
            "jobs": [
                "\u811a\u672c"
            ]
        },
        {
            "id": 19,
            "url": "http:\/\/bgm.tv\/person\/19",
            "name": "\u5927\u4e45\u4fdd\u667a\u5eb7",
            "name_cn": "\u5927\u4e45\u4fdd\u667a\u5eb7",
            "role_name": "",
            "images": null,
            "comment": 0,
            "collects": 0,
            "info": {
                "name_cn": "\u5927\u4e45\u4fdd\u667a\u5eb7",
                "alias": {
                    "kana": "\u304a\u304a\u304f\u307c \u3068\u3082\u3084\u3059",
                    "romaji": "Ookubo Tomoyasu"
                },
                "gender": "\u7537"
            },
            "jobs": [
                "\u811a\u672c"
            ]
        },
        {
            "id": 3016,
            "url": "http:\/\/bgm.tv\/person\/3016",
            "name": "\u7389\u4e95\u2606\u8c6a",
            "name_cn": "\u7389\u4e95\u8c6a",
            "role_name": "",
            "images": {
                "large": "http:\/\/lain.bgm.tv\/pic\/crt\/l\/a7\/81\/3016_prsn_845Ta.jpg",
                "medium": "http:\/\/lain.bgm.tv\/pic\/crt\/m\/a7\/81\/3016_prsn_845Ta.jpg",
                "small": "http:\/\/lain.bgm.tv\/pic\/crt\/s\/a7\/81\/3016_prsn_845Ta.jpg",
                "grid": "http:\/\/lain.bgm.tv\/pic\/crt\/g\/a7\/81\/3016_prsn_845Ta.jpg"
            },
            "comment": 1,
            "collects": 0,
            "info": {
                "name_cn": "\u7389\u4e95\u8c6a",
                "alias": {
                    "0": "\u7389\u4e95\u2605\u8c6a",
                    "kana": "\u305f\u307e\u3044\u3064\u3088\u3057",
                    "romaji": "Tamai Tsuyoshi"
                },
                "gender": "\u7537"
            },
            "jobs": [
                "\u811a\u672c"
            ]
        },
        {
            "id": 933,
            "url": "http:\/\/bgm.tv\/person\/933",
            "name": "\u690d\u7af9\u9808\u7f8e\u7537",
            "name_cn": "\u690d\u7af9\u987b\u7f8e\u7537",
            "role_name": "",
            "images": null,
            "comment": 2,
            "collects": 0,
            "info": {
                "name_cn": "\u690d\u7af9\u987b\u7f8e\u7537",
                "alias": {
                    "jp": "\u690d\u7af9\u9808\u7f8e\u7537",
                    "kana": "\u3046\u3048\u305f\u3051 \u3059\u307f\u304a",
                    "romaji": "Uetake Sumio"
                },
                "gender": "\u7537"
            },
            "jobs": [
                "\u811a\u672c"
            ]
        }
    ]
}
""".trimIndent()

class SubjectJsonParser(val JSONstr : String) {
    fun parseJson() : SubjectInfo? {
        try {
            val parser = JsonParser()
            val element = parser.parse(JSONstr)
            if (element.isJsonObject()) {
                val obj = element.asJsonObject
                val id = obj.get("id").asString
                val type = obj.get("type").asInt
                val name = obj.get("name").asString
                val cnName = obj.get("name_cn").asString
                val summary = obj.get("summary").asString
                val rating = obj.get("rating").asJsonObject
                val total_count = rating.get("total").asInt
                val score = rating.get("score").asDouble
                val rank = obj.get("rank").asString
                val eps = obj.get("eps").asDouble
                val epsCount = obj.get("eps_count").asDouble
                val image = obj.get("images").asJsonObject.get("small").asString
                val collection = obj.get("collection").asJsonObject
                val collection_num : ArrayList<Int> = ArrayList(listOf<Int>(
                    collection["wish"].asInt,
                    collection["collect"].asInt,
                    collection["doing"].asInt,
                    collection["on_hold"].asInt,
                    collection["dropped"].asInt
                ))
                val character_list = obj.get("crt").asJsonArray
                val character_list_arr = ArrayList<Chara>()
                character_list.forEach {
                    val name = it.asJsonObject["name"].asString
                    val name_cn = it.asJsonObject["name_cn"].asString
                    val show_name = when(name_cn == "") {
                        true -> name
                        else -> name_cn
                    }
                    val role_name = it.asJsonObject["role_name"].asString
                    // 主角、配角
                    val img_src = it.asJsonObject["images"].asJsonObject["grid"].asString
                    val cv = it.asJsonObject["actors"].asJsonArray.map {
                        it.asJsonObject["name"].asString
                    }.reduce { acc, s -> acc + " " + s }
                    character_list_arr.add(Chara(show_name, role_name, cv, img_src))
                }

                val staff_list = obj.get("staff").asJsonArray
                val staff_list_arr = ArrayList<Staff>()
                staff_list.forEach {
                    val name = it.asJsonObject["name"].asString
                    val name_cn = it.asJsonObject["name_cn"].asString
                    val show_name = when(name_cn == "") {
                        true -> name
                        else -> name_cn
                    }
                    val jobs = it.asJsonObject["jobs"].asJsonArray.map { i -> i.asString }
                        .reduce{str, e -> str + " " + e}
                    staff_list_arr.add(Staff(show_name, jobs))
                }

                val subject = SubjectInfo(
                    id,
                    name,
                    cnName,
                    when(type) {
                        1 -> TypeOfSubject.BOOK
                        2 -> TypeOfSubject.ANIME
                        3 -> TypeOfSubject.MUSIC
                        4 -> TypeOfSubject.GAME
                        6 -> TypeOfSubject.REAL
                        else -> TypeOfSubject.GAME
                    },
                    score.toString(), total_count, rank, collection_num,
                    epsCount.toString(), eps.toString(), summary,
                    character_list_arr, staff_list_arr
                )
                println(subject)
                return subject
            }
        } catch (e : Exception) {
            println(e.message)
        }
        return null
    }
}
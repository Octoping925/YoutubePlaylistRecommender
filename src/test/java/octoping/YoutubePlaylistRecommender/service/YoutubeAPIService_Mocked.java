package octoping.YoutubePlaylistRecommender.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import octoping.YoutubePlaylistRecommender.common.utility.ApiConnection;
import octoping.YoutubePlaylistRecommender.vo.CommentVO;
import octoping.YoutubePlaylistRecommender.vo.PlaylistVO;
import org.json.JSONArray;
import org.json.JSONObject;

public class YoutubeAPIService_Mocked implements YoutubeService {
    final String videoOverview = "{\"kind\":\"youtube#videoListResponse\",\"pageInfo\":{\"totalResults\":1,\"resultsPerPage\":1},\"etag\":\"xYI7zF4I61fzWgVkBPparvGuNSA\",\"items\":[{\"snippet\":{\"publishedAt\":\"2020-05-13T02:37:34Z\",\"localized\":{\"description\":\"♬ 해당 플레이리스트는 벅스 뮤직PD 'THE_HOOK'님께서 제작하였습니다\\n\\nPlaylist by THE_HOOK\\nWebsite :: http://bugs.kr/!yt0111\\nMore Playlist :: http://bugs.kr/!yt0111pd\\n\\nmusic to make your day.\\n\\n#나만알고싶은 #트렌디한 #음악 #플레이리스트 #팝송\",\"title\":\"[Playlist] 아, 이 노래들은 진짜 알려주기 아까운데ㅣOh, I really don't want to tell you these songs\"},\"description\":\"♬ 해당 플레이리스트는 벅스 뮤직PD 'THE_HOOK'님께서 제작하였습니다\\n\\nPlaylist by THE_HOOK\\nWebsite :: http://bugs.kr/!yt0111\\nMore Playlist :: http://bugs.kr/!yt0111pd\\n\\nmusic to make your day.\\n\\n#나만알고싶은 #트렌디한 #음악 #플레이리스트 #팝송\",\"title\":\"[Playlist] 아, 이 노래들은 진짜 알려주기 아까운데ㅣOh, I really don't want to tell you these songs\",\"thumbnails\":{\"standard\":{\"width\":640,\"url\":\"https://i.ytimg.com/vi/OEZc_c7A7Ko/sddefault.jpg\",\"height\":480},\"default\":{\"width\":120,\"url\":\"https://i.ytimg.com/vi/OEZc_c7A7Ko/default.jpg\",\"height\":90},\"high\":{\"width\":480,\"url\":\"https://i.ytimg.com/vi/OEZc_c7A7Ko/hqdefault.jpg\",\"height\":360},\"maxres\":{\"width\":1280,\"url\":\"https://i.ytimg.com/vi/OEZc_c7A7Ko/maxresdefault.jpg\",\"height\":720},\"medium\":{\"width\":320,\"url\":\"https://i.ytimg.com/vi/OEZc_c7A7Ko/mqdefault.jpg\",\"height\":180}},\"channelId\":\"UCSGC87iX0QhnIfUOI_B_Rdg\",\"categoryId\":\"10\",\"channelTitle\":\"essential;\",\"tags\":[\"playlist\",\"플레이리스트\",\"팝송\",\"노래\",\"음악\",\"노래 추천\",\"음악 추천\",\"팝송 추천\",\"에센셜\",\"essential\",\"essential;\",\"좋은 노래\",\"좋은 노래 추천\",\"애센셜\"],\"liveBroadcastContent\":\"none\"},\"kind\":\"youtube#video\",\"etag\":\"ePQdZDA75iQebtgl_b6eljzJWO8\",\"id\":\"OEZc_c7A7Ko\"}]}";
    final String videoComment = "{\"kind\":\"youtube#commentThreadListResponse\",\"nextPageToken\":\"QURTSl9pMlgwOE1yeE5PQ0dWV3F5NmRtUEIxdXZuNmNTb19CbU5KdG1FWlptQlNRZ0FRTmQtVFFySkdZX21KQ3JYbnhiRUs0T1c4N2VmN2RhZHk4QzJiSUduNVk0WTRBdVE=\",\"pageInfo\":{\"totalResults\":20,\"resultsPerPage\":20},\"etag\":\"T-EKeNR2UqKZAsfvFuU07UxrhRw\",\"items\":[{\"snippet\":{\"canReply\":true,\"totalReplyCount\":14,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"♬ 해당 플레이리스트는 벅스 뮤직PD &#39;THE_HOOK&#39;님께서 제작하였습니다\\r<br>\\r<br>Playlist by THE_HOOK\\r<br>Website :: <a href=\\\"http://bugs.kr/!yt0111\\\">http://bugs.kr/!yt0111\\r<\\/a><br>More Playlist :: <a href=\\\"http://bugs.kr/!yt0111pd\\\">http://bugs.kr/!yt0111pd\\r<\\/a><br>\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=49m29s\\\">49:29<\\/a> (여기를 누른 후 재생하시면, 광고없이 들을 수 있습니다)<br><br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=00m01s\\\">00:01<\\/a> Baynk - Poolside\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=03m31s\\\">03:31<\\/a> Ant Saunders - Yellow Hearts\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=07m15s\\\">07:15<\\/a> Mizmo - With U\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=10m04s\\\">10:04<\\/a> Small Talk - Blue\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=13m02s\\\">13:02<\\/a> Oliver Nelson - Talk (feat. Linae)\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=16m36s\\\">16:36<\\/a> Gryffin - Bye Bye (feat. Ivy Adara)\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=20m07s\\\">20:07<\\/a> Jeremy Zucker - end\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=23m57s\\\">23:57<\\/a> Chemical Neon - By My Side (feat. Eva Vinjor)\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=27m08s\\\">27:08<\\/a> MAX - Acid Dreams\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=30m13s\\\">30:13<\\/a> Sam Smith - I&#39;m Ready\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=33m34s\\\">33:34<\\/a> almost monday - parking lot view\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=36m33s\\\">36:33<\\/a> John K - 6 months\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=40m10s\\\">40:10<\\/a> Colin Hook - You Can Go\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=42m48s\\\">42:48<\\/a> Above Envy - All Out\\r<br><a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=46m08s\\\">46:08<\\/a> Robotaki - Dreamcatcher (Feat. Miko)\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu9I_o5dok5_ZSuZQPzS5__4R2g6IqYpNAncmQee=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2020-05-13T02:38:26Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCSGC87iX0QhnIfUOI_B_Rdg\",\"authorChannelId\":{\"value\":\"UCSGC87iX0QhnIfUOI_B_Rdg\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":512,\"textOriginal\":\"♬ 해당 플레이리스트는 벅스 뮤직PD 'THE_HOOK'님께서 제작하였습니다\\r\\n\\r\\nPlaylist by THE_HOOK\\r\\nWebsite :: http://bugs.kr/!yt0111\\r\\nMore Playlist :: http://bugs.kr/!yt0111pd\\r\\n\\r\\n49:29 (여기를 누른 후 재생하시면, 광고없이 들을 수 있습니다)\\n\\n00:01 Baynk - Poolside\\r\\n03:31 Ant Saunders - Yellow Hearts\\r\\n07:15 Mizmo - With U\\r\\n10:04 Small Talk - Blue\\r\\n13:02 Oliver Nelson - Talk (feat. Linae)\\r\\n16:36 Gryffin - Bye Bye (feat. Ivy Adara)\\r\\n20:07 Jeremy Zucker - end\\r\\n23:57 Chemical Neon - By My Side (feat. Eva Vinjor)\\r\\n27:08 MAX - Acid Dreams\\r\\n30:13 Sam Smith - I'm Ready\\r\\n33:34 almost monday - parking lot view\\r\\n36:33 John K - 6 months\\r\\n40:10 Colin Hook - You Can Go\\r\\n42:48 Above Envy - All Out\\r\\n46:08 Robotaki - Dreamcatcher (Feat. Miko)\",\"authorDisplayName\":\"essential;\",\"viewerRating\":\"none\",\"updatedAt\":\"2020-05-13T02:38:33Z\"},\"kind\":\"youtube#comment\",\"etag\":\"h5mqsvfKf8lzpLdvdLN-lSQhnZM\",\"id\":\"UgwU3uU-kgAuseXE7sd4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"Iv532uxcE-W7k0PS_6g6fgYip98\",\"id\":\"UgwU3uU-kgAuseXE7sd4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"알려주기 싫대서 왔는데  다 알고 있는 곡들이면 기분 완즈이 째즈요\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/OLf5NbOf3WlI3rtXdzIrA_tFHovd-BDOI6A3_f4TVlW5HrSaCYNrP_E1T0DNGveH_S0kY4bkKA=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-07-18T00:30:28Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UChE-huQIFTiH9EeVi5mx0kA\",\"authorChannelId\":{\"value\":\"UChE-huQIFTiH9EeVi5mx0kA\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"알려주기 싫대서 왔는데  다 알고 있는 곡들이면 기분 완즈이 째즈요\",\"authorDisplayName\":\"출근하기싫다\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-07-18T00:30:28Z\"},\"kind\":\"youtube#comment\",\"etag\":\"vc-p39UdMujvh2BLRKEsQX7q6h0\",\"id\":\"Ugzcj2QSKZpiwAUGr2R4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"pkaWiYycMVsbF57Sp8U-R9tVRQA\",\"id\":\"Ugzcj2QSKZpiwAUGr2R4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"머리털부터 꼬리털까지 전부 서버렸다..지릴뻔...\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/V76occAvsgXgQ9FDuyhc0XRPphVLLpyU5s52YyJWAADKlGddO6_UcdzJngZgYzF6zi_r0VOo=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-07-14T09:40:45Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UC4u479tPca24T9TDVAkTiOw\",\"authorChannelId\":{\"value\":\"UC4u479tPca24T9TDVAkTiOw\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"머리털부터 꼬리털까지 전부 서버렸다..지릴뻔...\",\"authorDisplayName\":\"룽지X시루 견생일기\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-07-14T09:40:45Z\"},\"kind\":\"youtube#comment\",\"etag\":\"dlFpCYLVmbQvjdHVz4cSJcdQjXk\",\"id\":\"UgyHAn4JH6MfFD4LYRJ4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"n_UuDqRb8hkmTAHCwd26-CR6CEY\",\"id\":\"UgyHAn4JH6MfFD4LYRJ4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"역시 선곡 맛집은.여기뿐이여용ㅎㅎㅎ 언제나 돌고돌다보면 항상 머무르는 곳은 이곳이랍니다~~이젠 장착하려구요 앞으로 더 좋은 노래 부탁드려요^^\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu9kBbpjH4s50UpuNf4W-e6KuIlwGVinhwjFBlI2bQ=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-07-03T14:51:23Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCpvg52i9Q2Bkop80fdKX1eA\",\"authorChannelId\":{\"value\":\"UCpvg52i9Q2Bkop80fdKX1eA\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"역시 선곡 맛집은.여기뿐이여용ㅎㅎㅎ 언제나 돌고돌다보면 항상 머무르는 곳은 이곳이랍니다~~이젠 장착하려구요 앞으로 더 좋은 노래 부탁드려요^^\",\"authorDisplayName\":\"유라라\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-07-03T14:51:23Z\"},\"kind\":\"youtube#comment\",\"etag\":\"TCeAT9IDQP4758BpTDswZ1yZxE8\",\"id\":\"Ugwr3GCJX8YuEb-Vy4h4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"m_LPgD4Ar_l2SkAAwgXfiqSkMBY\",\"id\":\"Ugwr3GCJX8YuEb-Vy4h4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"최애플리\\u2026요즘도 듣고 있어요 사랑해요\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/86KwJOrjZiykKDwpcQeSmlBld12ttkEY5fa3_sTWwimUH1hNK9HcLv5hK2UtP8Mj2YrC1DyfeA=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-06-20T08:59:11Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UC31QCPR2Zkj3-SclK6czAEw\",\"authorChannelId\":{\"value\":\"UC31QCPR2Zkj3-SclK6czAEw\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"최애플리\\u2026요즘도 듣고 있어요 사랑해요\",\"authorDisplayName\":\"과다복용\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-06-20T08:59:11Z\"},\"kind\":\"youtube#comment\",\"etag\":\"QXjrgEGVFtW-LlBUHZeSw_1rXSs\",\"id\":\"UgyHKlTvHAkvlVIpzRp4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"9CSGK6LkaM_K3TrA-8uL6B4ayvM\",\"id\":\"UgyHKlTvHAkvlVIpzRp4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"하 ㅠㅠㅠ 내 최애 노래 yellow hearts가 나와버려서 너무 놀람 ㅠㅠ 이미 까발려진 띵곡 많이 들어주세요\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu-46oaJnh5LdWl-wbs2hCuSNeJ0SW5nEAdPZzRw=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-06-04T10:42:20Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCRKoAuIyPuR1ntv1LN7w7-w\",\"authorChannelId\":{\"value\":\"UCRKoAuIyPuR1ntv1LN7w7-w\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"하 ㅠㅠㅠ 내 최애 노래 yellow hearts가 나와버려서 너무 놀람 ㅠㅠ 이미 까발려진 띵곡 많이 들어주세요\",\"authorDisplayName\":\"딸바\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-06-04T10:52:57Z\"},\"kind\":\"youtube#comment\",\"etag\":\"0afNbZ6MnWliAYHP3xihQsSTQzU\",\"id\":\"Ugw3-EYO6nG5GeXKRDR4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"1nG99lDt9Gf5rUpAv8S19QtO-AM\",\"id\":\"Ugw3-EYO6nG5GeXKRDR4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"오오옹오 내가 좋아하는 노래가 첫도입부에! 와우우우\uD83E\uDEE1\uD83E\uDD0D\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/_JsPgRo3C-PmEsGoawomfneRAq8RTB-hgUpjL-cRwgQtKElSF_bNiVeDgutAYOi_Hj6Phu_ESQ=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-06-02T00:23:45Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCHs_yQNhdnNoujaF-Mvz98Q\",\"authorChannelId\":{\"value\":\"UCHs_yQNhdnNoujaF-Mvz98Q\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"오오옹오 내가 좋아하는 노래가 첫도입부에! 와우우우\uD83E\uDEE1\uD83E\uDD0D\",\"authorDisplayName\":\"oliviayounghee90 \",\"viewerRating\":\"none\",\"updatedAt\":\"2022-06-02T00:23:45Z\"},\"kind\":\"youtube#comment\",\"etag\":\"TUixPjRJMKf5EG9bEAkPpVqjwx8\",\"id\":\"Ugz3uvyaD_0trVBEeJB4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"LkGWMSJGH1pYCDhlP4omrt4dCI4\",\"id\":\"Ugz3uvyaD_0trVBEeJB4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"2년후..지금도 지리고있다\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/D-cdEo1QNx3NkirEwbL6uSesu3zvXL--mwdLdP5uxWJqINHJeYCPBAYgyGeOaH3vtifcUKc2lQo=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-05-17T00:07:09Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCzvEz9obBEIhRRAqzuCvdRA\",\"authorChannelId\":{\"value\":\"UCzvEz9obBEIhRRAqzuCvdRA\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"2년후..지금도 지리고있다\",\"authorDisplayName\":\"콩스_\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-05-17T00:07:09Z\"},\"kind\":\"youtube#comment\",\"etag\":\"2uOsp4kNMjYtcJPz7bpUs-Y6aVg\",\"id\":\"Ugy_sRWxLOp9U61Ajj14AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"xOhI0wrfK829wQkGNJaLrvYrMgI\",\"id\":\"Ugy_sRWxLOp9U61Ajj14AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"크,,,,,,,,찐이네요\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDE4F\uD83C\uDFFB\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu-DPeaLZYsOI0NQSIfoC6g8-lOfCCKkJDR-cxyOTLI=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-04-28T14:12:42Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UClbXb0Ztzfx44RYqepXQNxg\",\"authorChannelId\":{\"value\":\"UClbXb0Ztzfx44RYqepXQNxg\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"크,,,,,,,,찐이네요\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDC4D\uD83C\uDFFB\uD83D\uDE4F\uD83C\uDFFB\",\"authorDisplayName\":\"한나\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-04-28T14:13:17Z\"},\"kind\":\"youtube#comment\",\"etag\":\"bQ0hlEFh53oFySYaZR250gjhD10\",\"id\":\"UgxbiCdldbekaKs02Oh4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"YGUKojUX7amxwznGkPNY7KG4gac\",\"id\":\"UgxbiCdldbekaKs02Oh4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"와 첫곡부터 내서타일!!! 드뎌 찾았다!!!\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu_WOPalWlV3-Ay1qTbXqc3DAu5VW8c3ix_B8Y2-TQ=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-04-27T06:23:13Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UC2EW81K_ZszFYg5Bv2-JaFQ\",\"authorChannelId\":{\"value\":\"UC2EW81K_ZszFYg5Bv2-JaFQ\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"와 첫곡부터 내서타일!!! 드뎌 찾았다!!!\",\"authorDisplayName\":\"shu E\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-04-27T06:23:13Z\"},\"kind\":\"youtube#comment\",\"etag\":\"xK-mwq7OzSV733N1RtbMwKB19Yk\",\"id\":\"UgwF6g-iFnutGzTP4cF4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"Ivkad2uN3vKBi6EyI_rxEjNRUxI\",\"id\":\"UgwF6g-iFnutGzTP4cF4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"ㅁㅊ시작부터 취저\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/4JrON0nTIBabEI7gRb4a6HP0Z-orGYtoTX9JfuiExXfM0EFtKFxZlxZ0GlMmpRhQH2K5GsOnhw=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-04-26T10:43:09Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UC2Fc4LrIvQ5C9y3fAoUVp9Q\",\"authorChannelId\":{\"value\":\"UC2Fc4LrIvQ5C9y3fAoUVp9Q\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":1,\"textOriginal\":\"ㅁㅊ시작부터 취저\",\"authorDisplayName\":\"오션뷰Oceanview_그림\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-04-26T10:43:09Z\"},\"kind\":\"youtube#comment\",\"etag\":\"UAUBbmvqrpg8dyOFz7xQIHhZV2E\",\"id\":\"Ugy95vDFzNkVoesT-Sh4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"nvfvZP9BoAnT5PS70ndI1MuOJdY\",\"id\":\"Ugy95vDFzNkVoesT-Sh4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"<a href=\\\"https://www.youtube.com/watch?v=OEZc_c7A7Ko&amp;t=20m07s\\\">20:07<\\/a>\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu8Zxil_P6OdwQs_8xO0NnOpLppVtYVpK3QcNmeBGt0LZTKOvjpvzVtYAwlHcdRKnwUaTPM=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-04-20T03:19:55Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCjhAkgn-2c-F-IWi2kFHtsQ\",\"authorChannelId\":{\"value\":\"UCjhAkgn-2c-F-IWi2kFHtsQ\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"20:07\",\"authorDisplayName\":\"나연\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-04-20T03:19:55Z\"},\"kind\":\"youtube#comment\",\"etag\":\"ZC0Bagy0jrG-7VWwOIO55MPELfA\",\"id\":\"UgwGT3cIM_Pa_Ml2BlB4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"1mOe4ilIPgpKox7jnyqmdnBROTI\",\"id\":\"UgwGT3cIM_Pa_Ml2BlB4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"Thank you<br>essential\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu-jpcoAb-QK_AFf3-GBad-aypucHXPiq7pE02iF=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-04-14T15:43:37Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCytbLYysDVJCz4Wq6yiIdlg\",\"authorChannelId\":{\"value\":\"UCytbLYysDVJCz4Wq6yiIdlg\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"Thank you\\nessential\",\"authorDisplayName\":\"Shine\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-04-14T15:43:37Z\"},\"kind\":\"youtube#comment\",\"etag\":\"j6igsmWHAKEuMCitexh5uC2kDGo\",\"id\":\"UgyNWolZwve2R8CM5xh4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"3vzgvKbL8BBr6IXUp0fDf4mycQk\",\"id\":\"UgyNWolZwve2R8CM5xh4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"플리에 댓글 다는 거 처음이에요ㅠㅠ 딱 제가 찾던 느낌ㅜㅠ엄청 과하지도 않지만 기분은 서서히 좋아지고 이렇게 노래로 하루를 다 채우고 싶은 플레이리스트는 처음이에요!!\\r<br>정말 너무너무 감사합니다 오늘 듣고 내일도 듣고 매일 기분 좋은 하루 만들 수 있을 것 같아용ㅎㅎ 옐럭님도 언제나 좋은 하루 보내셨으면 좋겠어요!!\uD83C\uDF38\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/6W4vUWKvMWsGLvHeQJO22WjgYqhmv28OC16QykvLJm2ircSstgi7f51gJReK_biEJyfnc0T8FA=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-03-30T09:13:37Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UC-YZpKP8Ubgf2sHX6FzBJ4g\",\"authorChannelId\":{\"value\":\"UC-YZpKP8Ubgf2sHX6FzBJ4g\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":6,\"textOriginal\":\"플리에 댓글 다는 거 처음이에요ㅠㅠ 딱 제가 찾던 느낌ㅜㅠ엄청 과하지도 않지만 기분은 서서히 좋아지고 이렇게 노래로 하루를 다 채우고 싶은 플레이리스트는 처음이에요!!\\r\\n정말 너무너무 감사합니다 오늘 듣고 내일도 듣고 매일 기분 좋은 하루 만들 수 있을 것 같아용ㅎㅎ 옐럭님도 언제나 좋은 하루 보내셨으면 좋겠어요!!\uD83C\uDF38\",\"authorDisplayName\":\"음악 작은 코너\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-03-30T09:13:37Z\"},\"kind\":\"youtube#comment\",\"etag\":\"Er_rtRyr_2G1k_BUMoGQRoYNlDQ\",\"id\":\"Ugxl-bU6w7IHCRPz2Yt4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"97ViYp4T5QqIYp5P7IhaDIP8Aok\",\"id\":\"Ugxl-bU6w7IHCRPz2Yt4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"이번 영상 이미지 너무 마음에 든당♥ 물론 노래들도!\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/wOaYb3tmddwDd4PQZgjsOZ-Dfsyrn41X0AZZ3vLkA40ZdUNx4N4G0nufkp6VrahWQAC7uRx3iw=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-03-17T19:17:03Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCzw86ClXJvK97Nw1BDe2-BQ\",\"authorChannelId\":{\"value\":\"UCzw86ClXJvK97Nw1BDe2-BQ\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":2,\"textOriginal\":\"이번 영상 이미지 너무 마음에 든당♥ 물론 노래들도!\",\"authorDisplayName\":\"CHITUS\uD83D\uDC96⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-03-17T19:17:03Z\"},\"kind\":\"youtube#comment\",\"etag\":\"bEdnbFit6ksiEWO1iCv3NrQDhAM\",\"id\":\"UgyFKrNIjeg4gr9qGCV4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"KOe1uDt0fIxdkOtt5XmQP5mYba0\",\"id\":\"UgyFKrNIjeg4gr9qGCV4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"첫 곡 부터 막 곡 까지 전부 오지고 지리고 똥 나오게 좋음\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu9ldCt-Phe-TiUiI5cpvMPJCgFXs6n32kqfWtynKA=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-03-15T04:05:31Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCDbAahfI_UtyOBpZ4f0MBqQ\",\"authorChannelId\":{\"value\":\"UCDbAahfI_UtyOBpZ4f0MBqQ\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"첫 곡 부터 막 곡 까지 전부 오지고 지리고 똥 나오게 좋음\",\"authorDisplayName\":\"avec\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-03-15T04:05:31Z\"},\"kind\":\"youtube#comment\",\"etag\":\"AflIFIXMv71oaboNw1HIxZANazY\",\"id\":\"UgyyoOw7fH7KS8AeFmF4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"aegF7apuztAqJuJ_7bNnAuGe2fQ\",\"id\":\"UgyyoOw7fH7KS8AeFmF4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"우키팝보고 또 들으러 왔어여\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu_2b7OQnRCTvyxoTG1Qka3eRCpcSEZ9MadJ1g=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-02-25T14:44:14Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCafYn8tKO7plsoObuW1fJLg\",\"authorChannelId\":{\"value\":\"UCafYn8tKO7plsoObuW1fJLg\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":2,\"textOriginal\":\"우키팝보고 또 들으러 왔어여\",\"authorDisplayName\":\"유은선\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-02-25T14:44:14Z\"},\"kind\":\"youtube#comment\",\"etag\":\"v8tDAs8Bj4voKrISpM-ImzflnuY\",\"id\":\"UgzAmBd_aHZKls_3Qdh4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"ODQTmh2_v45608L7Y145IwUD0A8\",\"id\":\"UgzAmBd_aHZKls_3Qdh4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"꽈\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AMLnZu9rZbyhJQFjrRO4_5S8S489LqbfsrMMrQvnIQ=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-02-15T11:27:08Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCUY072dqP2gT0b8o78g_-4w\",\"authorChannelId\":{\"value\":\"UCUY072dqP2gT0b8o78g_-4w\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"꽈\",\"authorDisplayName\":\"김김진\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-02-15T11:27:08Z\"},\"kind\":\"youtube#comment\",\"etag\":\"k8IVEa7HROjDsQ6ewssukjK1aBI\",\"id\":\"Ugw7oLQZ5OXBE5T4XW54AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"WD0v_fWpBtMu87408VrI8S9Jn-M\",\"id\":\"Ugw7oLQZ5OXBE5T4XW54AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"내 방이 하와이다~~~~\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ViwYGVyWGlpSHBfqhMWDP2z3BaGVF4J2x0gROt_TJXBxKEao5vhRwz36jRvAIuH6ZovmZ2AUBd8=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-01-25T11:03:22Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCZqrNVVLvtWZ25K3eZ2QTlg\",\"authorChannelId\":{\"value\":\"UCZqrNVVLvtWZ25K3eZ2QTlg\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"내 방이 하와이다~~~~\",\"authorDisplayName\":\"Kate\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-01-25T11:03:22Z\"},\"kind\":\"youtube#comment\",\"etag\":\"oTYv-hFK7gjBdsl1byMHT5lCmqc\",\"id\":\"UgwQfNvISlV2MEI_WjF4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"K9_Oi22sEl-iY0IwN5LYXcJUKqk\",\"id\":\"UgwQfNvISlV2MEI_WjF4AaABAg\"},{\"snippet\":{\"canReply\":true,\"totalReplyCount\":0,\"topLevelComment\":{\"snippet\":{\"textDisplay\":\"오늘도 좋은 노래 감사합니다\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/3-XpVJhg0KJprt9Ij_rCmSOdQ9YMXGYFMLS21n2MFRqsnzYN7iizylibfpugDCTR2ZaDQgjfOQ=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"publishedAt\":\"2022-01-19T23:04:47Z\",\"authorChannelUrl\":\"http://www.youtube.com/channel/UCEKTBWsZkN8_mLxoxP1AJnw\",\"authorChannelId\":{\"value\":\"UCEKTBWsZkN8_mLxoxP1AJnw\"},\"videoId\":\"OEZc_c7A7Ko\",\"likeCount\":0,\"textOriginal\":\"오늘도 좋은 노래 감사합니다\",\"authorDisplayName\":\"LUNA\",\"viewerRating\":\"none\",\"updatedAt\":\"2022-01-19T23:04:47Z\"},\"kind\":\"youtube#comment\",\"etag\":\"KmOoYfyN4M-DN9G6Rc00SdWlXs0\",\"id\":\"UgysYehXmMuBfl6emFx4AaABAg\"},\"isPublic\":true,\"videoId\":\"OEZc_c7A7Ko\"},\"kind\":\"youtube#commentThread\",\"etag\":\"cV0HMVKwBLaG_mHNcdShMf8HkOM\",\"id\":\"UgysYehXmMuBfl6emFx4AaABAg\"}]}\n";

    public PlaylistVO getYoutubeVideoOverview(String videoId) {
        JSONObject json = new JSONObject(videoOverview);
        JSONObject snippet = (JSONObject)((JSONObject)((JSONArray) json.get("items")).get(0)).get("snippet");

        String title = (String)snippet.get("title");
        String description = (String)snippet.get("description");
        String channelTitle = (String)snippet.get("channelTitle");

        return new PlaylistVO(title, description, channelTitle);
    }

    public List<CommentVO> getYoutubeVideoComment(String videoId) throws IOException {
        JSONObject json = new JSONObject(videoComment);

        List<CommentVO> vo = new ArrayList<>();
        JSONArray items = (JSONArray) json.get("items");
        items.forEach(item -> {
            JSONObject topLevelComment = (JSONObject)((JSONObject)((JSONObject)item).get("snippet")).get("topLevelComment");
            JSONObject snippet = (JSONObject) topLevelComment.get("snippet");

            // 타임라인이 없는 댓글은 무시한다
            String textDisplay = (String) snippet.get("textDisplay");
            if(textDisplay.contains("<a href=\"https://www.youtube.com/watch?")) {
                String writer = (String) snippet.get("authorDisplayName");
                String content = (String) snippet.get("textOriginal");
                vo.add(new CommentVO(writer, content));
            }
        });

        return vo;
    }
}
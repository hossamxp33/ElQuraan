package com.codesroots.elquraan.Helpers;

import com.codesroots.elquraan.Models.Agzaa_Model;
import com.codesroots.elquraan.Models.All_Sour_Model;
import com.codesroots.elquraan.Models.FullQuranModel;
import com.codesroots.elquraan.Models.MawakitModel;
import com.codesroots.elquraan.Models.QuranModel;
import com.codesroots.elquraan.Models.SewarModel;
import com.codesroots.elquraan.Models.SouraModel;
import com.codesroots.elquraan.Models.TafaseerModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ali on 1/24/2018.
 */
public interface ApiInterface {
    //    @Multipart
//    @Headers("Accept: Application/json")
//    @POST("users/token.json")
//    Call<LoginModel> Login(
//
//            @Part("password") RequestBody password,
//            @Part("username") RequestBody username);
//
//
//    @Multipart
//    @Headers("Accept: Application/json")
//    @POST("users/add.json")
//    Call<RegisterModel> Register(
//
//            @Part("username") RequestBody name,
//            @Part("password") RequestBody pass,
//            @Part("email") RequestBody email,
//            @Part("user_group_id") RequestBody groupid);
//
//

    @GET("quraan/index.json")
    @Headers("Accept: Application/json")
    Call<FullQuranModel> getFullQuran(

    );

    @GET("quraan.json")
    @Headers("Accept: Application/json")
    Call<QuranModel> getAllQuran(

    );


    @GET("quraan/suraImgs/{soura_id}.json")
    @Headers("Accept: Application/json")
    Call<SewarModel> getSewar(@Path(value = "soura_id", encoded = true) int soura_id
    );

    @GET("{city}.json")
    @Headers("Accept: Application/json")
    Call<MawakitModel> getMawakit(@Path(value = "city", encoded = true) String city,
                                  @Query("key") String key
    );


    @GET("OtherTafaseer.json")
    @Headers("Accept: Application/json")
    Call<TafaseerModel> getTafaseer();

    @GET("tafaseer/index.json")
    @Headers("Accept: Application/json")
    Call<SouraModel> getsourNames(
    );

    @GET("parts.json")
    @Headers("Accept: Application/json")
    Call<Agzaa_Model> getsourAgzaa(
    );

    @GET("Tafaseer/allQuraan.json")
    @Headers("Accept: Application/json")
    Call<All_Sour_Model> getAllSour(
    );



//    @GET("materials/allMaterials/{user_id}/{us}/{ff}/{kk}.json")
//    @Headers("Accept: Application/json")
//    Call<MaterialModel> getMawad(@Path(value = "user_id", encoded = true) String userId, @Path(value = "us", encoded = true) String fid,
//                                 @Path(value = "ff", encoded = true) String sid, @Path(value = "kk", encoded = true) String tid
//    );
//
//    @GET("advices/getAdvicesBylvlStudy/{us}/{ff}/{kk}.json")
//    @Headers("Accept: Application/json")
//    Call<AdviceModel> getAdvices(@Path(value = "us", encoded = true) String fid,
//                                 @Path(value = "ff", encoded = true) String sid, @Path(value = "kk", encoded = true) String tid
//    );
//
//    @GET("EngCourses/getEngCourseBylvlStudy/{us}/{ff}/{kk}/{userid}.json")
//    @Headers("Accept: Application/json")
//    Call<EnglishModel> getEnglishCourse(@Path(value = "us", encoded = true) String fid,
//                                        @Path(value = "ff", encoded = true) String sid,
//                                        @Path(value = "kk", encoded = true) String tid,
//                                        @Path(value = "userid", encoded = true) String userid
//    );
//
//
//    @GET("materials/allLessons/{uss}/{user_id}/{us}/{ff}/{kk}/{userid}.json")
//    @Headers("Accept: Application/json")
//    Call<LessonModel> getbookslessons(@Path(value = "uss", encoded = true) String userIds, @Path(value = "user_id", encoded = true) String fidsa, @Path(value = "us", encoded = true) String fid,
//                                      @Path(value = "ff", encoded = true) String sid,
//                                      @Path(value = "kk", encoded = true) String tid,
//                                      @Path(value = "userid", encoded = true) String userid
//
//    );
//
//    @GET("profiles/view/{user_id}.json")
//    @Headers("Accept: Application/json")
//    Call<ProfileModel> getProfile(@Path(value = "user_id", encoded = true) String userId);
//
//    @GET("posts/lastposts/{user_id}.json")
//    @Headers("Accept: Application/json")
//    Call<PostModel> getLastPosts(@Path(value = "user_id", encoded = true) String userId);
//
//    @GET("posts/mostlikes/{user_id}.json")
//    @Headers("Accept: Application/json")
//    Call<PostModel> getMostLiked(@Path(value = "user_id", encoded = true) String userId);
//
//    @GET("messages/myChat/{user_id}.json")
//    @Headers("Accept: Application/json")
//    Call<MyMessageModel> getMyChat(@Path(value = "user_id", encoded = true) String userId);
//
//    @GET("likePdf/myPdfLikes/{user_id}.json")
//    @Headers("Accept: Application/json")
//    Call<MohematModel> getMohemat(@Path(value = "user_id", encoded = true) String userId);
//    @GET("posts/postaty/{user_id}.json")
//    @Headers("Accept: Application/json")
//    Call<MyPostsModel> getMyposts(@Path(value = "user_id", encoded = true) String userId);
//
//     @Multipart
//    @Headers("Accept: Application/json")
//    @POST("likePdf/add.json")
//    Call<FavModel> pdfLike(@Part("user_id") RequestBody userid,
//                           @Part("lesson_id") RequestBody lesson_id);
//
//
//    @Multipart
//    @Headers("Accept: Application/json")
//    @POST("likePdf/add.json")
//    Call<FavModel> englishpdfLike(@Part("user_id") RequestBody userid,
//                                  @Part("eng_course_id") RequestBody eng_course_id);
//
//
//
//
//    @Multipart
//    @Headers("Accept: Application/json")
//    @POST("profiles/edit/{user_id}.json")
//    Call<EditProfileModel> EditProfile(@Path(value = "user_id", encoded = true) String userId,
//                                       @Part("level_id") RequestBody levelid,
//                                       @Part("sup_level_id") RequestBody sublevelid,
//                                       @Part("sup_mini_level_id") RequestBody subminilevelid,
//                                       @Part("city_id") RequestBody city,
//                                       @Part MultipartBody.Part photo);
//
//    @Multipart
//    @Headers("Accept: Application/json")
//    @POST("profiles/edit/{user_id}.json")
//    Call<EditProfileModel> EditProfileMain(@Path(value = "user_id", encoded = true) String userId,
//
//                                           @Part("level_id") RequestBody levelid,
//                                           @Part("sup_level_id") RequestBody sublevelid,
//                                           @Part("sup_mini_level_id") RequestBody subminilevelid,
//                                           @Part("city_id") RequestBody city,
//                                           @Part("photo") RequestBody photo);
//
//
//    @Multipart
//    //@Headers("Accept: Application/json")
//    @POST("posts/add.json")
//    Call<AddPostModel> ADDPOST(
//            @Part("user_id") RequestBody levelid,
//            @Part("post") RequestBody sublevelid,
//            @Part List<MultipartBody.Part> files);
//
//
//    //@Headers("Accept: Application/json")
//    @Multipart
//    @POST("likes/add.json")
//    Call<LikeModel> like(
//            @Part("user_id") RequestBody levelid,
//            @Part("post_id") RequestBody sublevelid);
//
//
//    @Multipart
//    @POST("replay/add.json")
//    Call<CommentModel> comment(
//            @Part("user_id") RequestBody levelid,
//            @Part("post_id") RequestBody sublevelid,
//            @Part("replay") RequestBody reply);
//
//    @Multipart
//    @POST("profiles/searchStudentByUsername.json")
//    Call<FindStudentModel> findstudent(
//            @Part("name") RequestBody name);
//
//    @Multipart
//    @POST("Chats/add.json")
//    Call<SendMessageModel> sendMessage(
//            @Part("post") RequestBody post,
//            @Part("user_id") RequestBody user_id,
//            @Part("too") RequestBody too,
//            @Part("fromm") RequestBody fromm,
//            @Part List<MultipartBody.Part> files);
//
//    @Multipart
//    @POST("Chats/chatBtnUsersByLvl.json")
//    Call<MessegesDetailModel> getMessegs(
//            @Part("too") RequestBody to,
//            @Part("fromm") RequestBody from);
//    @Multipart
//    @POST("users/couponActive.json")
//    Call<CouponModel> coupon(
//            @Part("coupon") RequestBody code,
//            @Part("userId") RequestBody userid);
//
//


}


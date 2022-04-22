package com.android.appmusic11.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.android.appmusic11.Adapter.MainViewPagerAdapter;
import com.android.appmusic11.Database.DatabaseHelper;
import com.android.appmusic11.Fragment.Fragment_Thu_Vien;
import com.android.appmusic11.Fragment.Fragment_Tim_Kiem;
import com.android.appmusic11.Fragment.Fragment_Trang_Chu;
import com.android.appmusic11.Fragment.LoadingDialog;
import com.android.appmusic11.R;
import com.google.android.material.tabs.TabLayout;

public class TrangChuActivity extends AppCompatActivity {
    public static DatabaseHelper databaseHelper ;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private long backPressTime;
    private Toast mToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
   databaseHelper = new DatabaseHelper(this,"h.sqlite",null,1);

//        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS BangXepHang(MaBangXepHang VARCHAR(200) PRIMARY KEY, TenBangXepHang NVARCHAR(200) ,HinhBangXepHang VARCHAR(200))");
//        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS ChuDe(MaChuDe VARCHAR(200) PRIMARY KEY, TenChuDe NVARCHAR(200) ,HinhChuDe VARCHAR(200))");
//        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS NgheSi(MaNgheSi VARCHAR(200) PRIMARY KEY, TenNgheSi NVARCHAR(200) ,HinhNgheSi VARCHAR(200))");
//        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS ThinhHanh(MaThinhHanh VARCHAR(200) PRIMARY KEY, TenThinhHanh NVARCHAR(200) ,HinhThinhHanh VARCHAR(200))");
//        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS PlayList(MaPlayList VARCHAR(200) PRIMARY KEY, TenPlayList NVARCHAR(200) ,HinhPlayList VARCHAR(200))");
//        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS BaiHat(MaBaiHat INTEGER PRIMARY KEY AUTOINCREMENT , TenBaiHat NVARCHAR(200) ,HinhBaiHat VARCHAR(200), TenCaSi NVARCHAR(200), LinkBaiHat VARCHAR(200), MaBangXepHang VARCHAR(200), MaChuDe VARCHAR(200), MaNgheSi VARCHAR(200), MaThinhHanh VARCHAR(200), MaPlayList VARCHAR(200), FOREIGN KEY (MaNgheSi) REFERENCES NgheSi(MaNgheSi))");
//
////        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS ThuVienPlayList(MaThuVienPlayList INTEGER PRIMARY KEY AUTOINCREMENT, TenThuVienPlayList NVARCHAR(200) ,HinhThuVienPlayList VARCHAR(200))");
////
////
//
//
//        //Insert Nghe Si
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS1','Sơn Tùng','https://i.scdn.co/image/ab6761610000e5ebc48716f91b7bf3016f5b6fbe')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS2','Đen','https://i.scdn.co/image/ab6761610000e5eb2868ae760ec4f1ec2223b6f9')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS3','Vũ','https://i.scdn.co/image/ab6761610000e5ebec1bd421630bf3ad110c09fa')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS4','Taylor Swift','https://media.doanhnghiepvn.vn/Images/Uploaded/Share/2021/11/14/thumb7_083239508188557.jpg')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS5','BTS','https://vtv1.mediacdn.vn/thumb_w/650/2019/12/6/bts-spotify-1575618793475790858242.jpg')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS6','RPT MCK','https://i.scdn.co/image/ab6761610000e5ebf9f78a9365ea257503d06f93')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS7','Binz','https://i.scdn.co/image/ab6761610000e5eb6f9ec80eb4598f551999c3ae')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS8','BigBang','https://vtv1.mediacdn.vn/thumb_w/650/2022/4/6/1649185719-untitled-1-16492321081411501749643.jpg')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS9','TheWeeknd','https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2022/1/25/998525/The-Weeknd-Sacrifice.jpg')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS10','Ariana Grande','https://i.scdn.co/image/ab6761610000e5ebcdce7620dc940db079bf4952')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS11','Hoàng Dũng','https://i.scdn.co/image/ab6761610000e5eb7c69d881a1b8bb05fcab83b5')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS12','Mỹ Tâm','https://i.scdn.co/image/ab6761610000e5ebe033eca862ece1cb7a3bed44')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS13','Charlie Puth','https://i.scdn.co/image/ab6761610000e5eb0d890ffd0e0bea5f904f1a9f')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS14','BlackPink','https://media-cdn-v2.laodong.vn/storage/newsportal/2021/3/16/889788/Blackpink-Thiet-Lap-.jpg?w=960&crop=auto&scale=both')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS15','Erik','https://i.scdn.co/image/ab6761610000e5eb63ba7b9441e542f3b2938b83')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS16','Doja Cat','https://i.scdn.co/image/ab6761610000e5eb727a2ac15afe659be999beba')");
//        databaseHelper.QueryData("INSERT INTO NgheSi VALUES('NS17','Ed Sheeran','https://i.scdn.co/image/ab6761610000e5eb12a2ef08d00dd7451a6dbed6')");
//
//
//
//        //Insert BaiHat
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Muộn Rồi Mà Sao Còn','https://i.ytimg.com/vi/xypzmu5mMPY/maxresdefault.jpg','Sơn Tùng','https://www.mboxdrive.com/MuonRoiMaSaoCon-SonTungMTP-7011803.mp3','','','NS1','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Chúng Ta Của Hiện Tại','https://bhn.vn/wp-content/uploads/2020/12/noi-bat-mv-15-phut-son-tung-mtp-chung-ta-cua-hien-tai-son-tung-m-tp.jpg','Sơn Tùng','https://www.mboxdrive.com/ChungTaCuaHienTaiBeat-SonTungMTP-6919087.mp3','','','NS1','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Có Chắc Yêu Là Đây','https://genk.mediacdn.vn/139269124445442048/2020/7/7/photo-1-1594099573995794597917.jpg','Sơn Tùng','https://www.mboxdrive.com/CoChacYeuLaDayOnionnRemix-SonTungMTPOnionn-7022615.mp3','','','NS1','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Âm Thầm Bên Em','https://i.pinimg.com/originals/5a/65/7f/5a657f1bdcf59ee636a6d8304204bfdf.jpg','Sơn Tùng','https://www.mboxdrive.com/AmThamBenEm-SonTungMTP-4066476.mp3','','','NS1','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Hãy Trao Cho Anh','https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2019/7/1/741911/Hay-Trao-Cho-Anh.jpg','Sơn Tùng','https://www.mboxdrive.com/HayTraoChoAnh-SonTungMTPSnoopDogg-6010660.mp3','','','NS1','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Gieo Quẻ','https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/1/2/ngang-1641132327544947971977.png','Đen','https://www.mboxdrive.com/GieoQue-HoangThuyLinhDen-7125031.mp3','','','NS2','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Lối Nhỏ','https://ghienreview.com/wp-content/uploads/2019/10/Ghien-review-Loi-nho-2.jpg','Đen','https://www.mboxdrive.com/LoiNho1-DenPhuongAnhDao-6129215.mp3','','','NS2','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Đi Về Nhà','https://vtv1.mediacdn.vn/thumb_w/650/2020/12/19/nkk2664-1608348105952437410015.jpg','Đen','https://www.mboxdrive.com/DiVeNha-DenJustaTee-6892051.mp3','','','NS2','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Mang Tiền Về Cho Mẹ','https://image.thanhnien.vn/1200x630/Uploaded/2022/kbfwobj/2021_12_30/hinh-1-5084.jpg','Đen','https://data.chiasenhac.com/down2/2215/4/2214701-52396a51/128/Mang%20Tien%20Ve%20Cho%20Me%20-%20Den_%20Nguyen%20Thao.mp3','','','NS2','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Bài Này Chill Phết','https://i.ytimg.com/vi/ddaEtFOsFeM/maxresdefault.jpg','Đen','https://www.mboxdrive.com/BaiNayChillPhet-DenMIN-5978903.mp3','','','NS2','','')");
//
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Bước Qua Nhau','https://image.phunuonline.com.vn/fckeditor/upload/2021/20211112/images/bai-hat-chua-lanh-nhung-_191636693103.jpg','Vũ','https://www.mboxdrive.com/BuocQuaNhau-Vu-7120388.mp3','','','NS3','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Bước qua mùa cô đơn','https://vtv1.mediacdn.vn/thumb_w/640/2020/12/12/13011574227482642587703838536921281072601730o-1607753998328414642826.jpg','Vũ','https://www.mboxdrive.com/BuocQuaMuaCoDon-Vu-6879419.mp3','','','NS3','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Lạ lùng','https://i.pinimg.com/originals/df/5f/d4/df5fd4fbed01dd865b0f40f1c96bb0d4.jpg','Vũ','https://www.mboxdrive.com/LaLung-Vu-4749614.mp3','','','NS3','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Đông kiếm em','https://i1.sndcdn.com/artworks-000504275367-mg0erb-t500x500.jpg','Vũ','https://www.mboxdrive.com/DongKiemEm-ThaiVu-4373753.mp3','','','NS3','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Phút ban đầu','https://i.ytimg.com/vi/4uAXzzMVrPk/maxresdefault.jpg','Vũ','https://www.mboxdrive.com/Phut%20Ban%20Dau%20-%20Vu.mp3','','','NS3','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Blank Space','https://file.tinnhac.com/resize/600x-/music/2017/03/20/wallpaper-7a02.jpg','Taylor Swift','https://www.mboxdrive.com/BlankSpace-TaylorSwift-6077900.mp3','','','NS4','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Lover','https://newsmd2fr.keeng.net/tiin/archive/images/280/201908/20190808/tinngan_022507_181714157_1.jpg','Taylor Swift','https://www.mboxdrive.com/Lover-TheSupremes-3413142.mp3','','','NS4','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Shake It Off','https://www.voca.vn/assets/img/news/Shake%20It%20Off-1498616104.jpg','Taylor Swift','https://www.mboxdrive.com/Shake%20It%20Off%20-%20Taylor%20Swift.mp3','','','NS4','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'I Dont Wanna Live Forever','https://file.tinnhac.com/resize/600x-/music/2017/01/29/maxresdefault-609f.jpg','Taylor Swift','https://www.mboxdrive.com/IDontWannaLiveForever-TravisGarland-4752136.mp3','','','NS4','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Widest Dreams','https://i.ytimg.com/vi/zeSdF0elweM/hqdefault.jpg','Taylor Swift','https://www.mboxdrive.com/WildestDreams-TaylorSwift-5810009.mp3','','','NS4','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Dynamite','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7FYlgx5MU_JixQLFrm40NajeBx9OA9LOBVWOfH37mhmu37Jt9Wf-66axfubQzrd14c5g&usqp=CAU','BTS','https://data3.chiasenhac.com/downloads/2112/4/2111387-e4b5d7a3/128/Dynamite%20-%20BTS.mp3','','','NS5','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Butter','https://image.thanhnien.vn/w1024/Uploaded/2022/mtfqu/2021_05_21/bts-hop-bao_htsq.jpg','BTS','https://data.chiasenhac.com/down2/2172/4/2171974-dd4a224c/128/Butter%20-%20BTS.mp3','','','NS5','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Boy With Luv','https://ss-images.saostar.vn/2019/04/13/4961599/jpg-jpeg-copy.jpg','BTS','https://www.mboxdrive.com/BoyWithLuvJapaneseVersion-BTS-6021566.mp3','','','NS5','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'My Universe','https://kenh14cdn.com/thumb_w/660/203336854389633024/2021/9/30/dummy-16329885912881039668728.jpeg','BTS','https://www.mboxdrive.com/MyUniverse-ColdplayXBTS-7096238.mp3','','','NS5','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Fake Love','https://static2.yan.vn/YanNews/2167221/201805/khong-ngo-bts-dat-duoc-ky-luc-khung-nho-nhu-the-nay-eb340086.jpg','BTS','https://www.mboxdrive.com/Fake%20Love%20-%20BTS.mp3','','','NS5','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Chìm Sâu','https://i1.sndcdn.com/artworks-XWhy73hN7XntEFlJ-rBzgxg-t500x500.jpg','RPT MCK','https://data.chiasenhac.com/down2/2230/4/2229564-d379b916/128/Chim%20Sau%20-%20MCK_%20Trung%20Tran.mp3','','','NS6','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Va Vào Giai Điệu Này','https://i.ytimg.com/vi/8JzeSeFsHGM/maxresdefault.jpg','RPT MCK','https://www.mboxdrive.com/VaVaoGiaiDieuNayFeatRptMck-RAPVIET-6804702.mp3','','','NS6','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Dân Chơi Xóm','https://i.ytimg.com/vi/Xt3y_TFBGQE/maxresdefault.jpg','RPT MCK','https://www.mboxdrive.com/DanChoiXomFeatRptMckJustatee-RAPVIET-6821316.mp3','','','NS6','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Iceman','https://avatar-ex-swe.nixcdn.com/song/2021/03/03/3/4/4/5/1614785212642_640.jpg','RPT MCK','https://www.mboxdrive.com/Iceman-Sol7RPTMCKDCOD-7031753.mp3','','','NS6','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Em Là Châu Báu','https://kenh14cdn.com/thumb_w/600/pr/2020/1606987668087-140-0-858-1150-crop-1606987679466-63742620569616.jpg','RPT MCK','https://www.mboxdrive.com/EmLaChauBau-RPTMCKTlinh-6843994.mp3','','','NS6','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Bigcityboi','https://image.phunuonline.com.vn/fckeditor/upload/2020/20200721/images/bigcityboi-loi-nhac-vo-nghia-_831595349934.png','Binz','https://www.mboxdrive.com/BigcityboiBeat-BinzTouliver-6932301.mp3','','','NS7','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Gene','https://ss-images.saostar.vn/2019/05/13/5177543/ava.jpg','Binz','https://www.mboxdrive.com/Gene-BinzTouliver-5961947.mp3','','','NS7','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Freaky Squad','https://static.mservice.io/blogscontents/momo-upload-api-220102100629-637767147895320279.jpg','Binz','https://data.chiasenhac.com/down2/2210/4/2209406-4798a530/128/Freaky%20Squad%20-%20Rhymastic_%20Binz_%20Soobin_.mp3','','','NS7','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Sao Cũng Được','https://i.pinimg.com/736x/e1/8d/7f/e18d7f1ebe23be72f643a520f6005122.jpg','Binz','https://www.mboxdrive.com/SaoCungDuocGuitarVersion-Binz-5411337.mp3','','','NS7','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'So Far','https://avatar-ex-swe.nixcdn.com/song/share/2019/02/12/6/6/8/5/1549953364682.jpg','Binz','https://www.mboxdrive.com/SoFar-Binz-5521790.mp3','','','NS7','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Still Life','https://image.thanhnien.vn/w1024/Uploaded/2022/zxaijr/2022_04_05/bigbangtaixuatkyluc1-9337.jpg','BigBang','https://data.chiasenhac.com/down2/2236/4/2235972-94a25050/128/Still%20Life%20-%20Big%20Bang.mp3','','','NS8','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Bang Bang Bang','https://kenh14cdn.com/thumb_w/660/2019/3/11/made-big-bang-15523119519041938616129.jpg','BigBang','https://www.mboxdrive.com/Bang%20Bang%20Bang%20KR_%20-%20BIG%20BANG.mp3','','','NS8','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Loser','https://i1.sndcdn.com/artworks-000148000766-aee1qe-t500x500.jpg','BigBang','https://www.mboxdrive.com/Loser-BIGBANG-6291940.mp3','','','NS8','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Haru Haru','https://i.pinimg.com/600x315/62/df/0d/62df0ddf882a428ca8c53167c29952bb.jpg','BigBang','https://www.mboxdrive.com/HaruHaru-BIGBANG-6291516.mp3','','','NS8','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Fxxk It','https://file.tinnhac.com/resize/600x-/music/2016/12/15/bb2-6567.png','BigBang','https://www.mboxdrive.com/FxxkIt-BIGBANG-6292297.mp3','','','NS8','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Blinding Lights','https://cdnmedia.thethaovanhoa.vn/Upload/3uPkfvAxvuOpUQrmKeiDaA/files/2020/06/A/26/Blinding1.jpg','TheWeeknd','https://www.mboxdrive.com/BlindingLights-TheWeeknd-6939332.mp3','','','NS9','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Save Your Tears','https://data.chiasenhac.com/data/cover/140/139217.jpg','TheWeeknd','https://www.mboxdrive.com/SaveYourTears-TheWeeknd-6939330.mp3','','','NS9','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'The Hills','https://i1.sndcdn.com/artworks-000175589765-tqo3nc-t500x500.jpg','TheWeeknd','https://www.mboxdrive.com/TheHills-TheWeeknd-4211096.mp3','','','NS9','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Star Boy','https://upload.wikimedia.org/wikipedia/en/1/12/Starboy_Legend_of_the_Fall_Tour_Poster.png','TheWeeknd','https://www.mboxdrive.com/Starboy%20-%20The%20Weeknd_%20Daft%20Punk.mp3','','','NS9','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Lost In The Fire','https://i.pinimg.com/564x/d3/8c/28/d38c285d73b9cc6efbce36bfbbe55991.jpg','TheWeeknd','https://www.mboxdrive.com/Lost%20In%20The%20Fire%20-%20Gesaffelstein_%20The%20We.mp3','','','NS9','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'7 Rings','https://i.vietgiaitri.com/2019/5/1/billboard-music-awards-2019-7-rings-duoc-tai-hien-ngay-dai-sanh--7be239.jpg','Ariana Grande','https://www.mboxdrive.com/7Rings-ArianaGrande-5880797.mp3','','','NS10','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Thank U, Next','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvNhM1c1piv8JW2yl8-MgRM2gNZWUYi0ZS7xqcr096QyLRvUdfcXyenKmuCXZwwcjukQE&usqp=CAU','Ariana Grande','https://www.mboxdrive.com/Thank%20U_%20Next%20-%20Ariana%20Grande.mp3','','','NS10','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Bang Bang','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNccpMjqDzzChCVWl6Yau1MyD00i-8eJ4lca0qc5xH22ASrVp8sggGp0gDs6xVWEZctp4&usqp=CAU','Ariana Grande','https://www.mboxdrive.com/Bang%20Bang%20-%20Ariana%20Grande_%20Jessie%20J_%20Nic.mp3','','','NS10','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'One Last Time','https://upload.wikimedia.org/wikipedia/vi/7/76/Ariana_Grande_One_Last_Time_Cover.png','Ariana Grande','https://www.mboxdrive.com/One%20Last%20Time%20-%20Ariana%20Grande.mp3','','','NS10','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Positions','https://kenh14cdn.com/thumb_w/660/2020/10/30/01-ariana-grande-press-photo-2020-cr-dave-meyers-billboard-1548-1603458796-compressed-16040343466341970982592.jpg','Ariana Grande','https://data3.chiasenhac.com/downloads/2126/4/2125027-5cb2d271/128/Positions%20-%20Ariana%20Grande.mp3','','','NS10','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Nàng Thơ','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxG5iM3B9Xtx1Uhaq1mx8Fx180DUIql_snYgwLsh2eJa8Yi5BzDF9VfCub0VOPKsq6MwI&usqp=CAU','Hoàng Dũng','https://www.mboxdrive.com/NangTho-HoangDung-6413381.mp3','','','NS11','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Yếu Đuối','https://i1.sndcdn.com/artworks-ZtNQOAAd9UkO8HSD-RXVrcw-t500x500.jpg','Hoàng Dũng','https://www.mboxdrive.com/YeuDuoi-NguyenHoangDung-5732265.mp3','','','NS11','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Đôi Lời','https://avatar-ex-swe.nixcdn.com/song/2018/11/05/8/2/4/0/1541408903015_640.jpg','Hoàng Dũng','https://www.mboxdrive.com/DoiLoi-HoangDung-5754832.mp3','','','NS11','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Khi Em Lớn','https://kenh14cdn.com/203336854389633024/2021/4/21/noname-16189672986651037049224.png','Hoàng Dũng','https://data.chiasenhac.com/down2/2167/5/2166081-17e69ffd/128/Khi%20Em%20Lon%20-%20Orange_%20Hoang%20Dung.mp3','','','NS11','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Chờ Anh Nhớ','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNIyCjpXPz1GOYGx9ppnNPjmuAF_ATVJSWLQ&usqp=CAU','Hoàng Dũng','https://www.mboxdrive.com/ChoAnhNhe-HoangDungHoangRob-4475500.mp3','','','NS11','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Hẹn Ước Từ Hư Vô','https://i.ytimg.com/vi/W4P8gl4dnrg/maxresdefault.jpg','Mỹ Tâm','https://data.chiasenhac.com/down2/2229/5/2228679/128/Hen%20Uoc%20Tu%20Hu%20Vo%20-%20My%20Tam.mp3','','','NS12','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Đúng Cũng Thành Sai','https://image.thanhnien.vn/w660/Uploaded/2022/znetns/2020_09_29/120315531_2926598707573515_5380064847434970052_o_tllr.jpg','Mỹ Tâm','https://www.mboxdrive.com/DungCungThanhSai-MyTam-6689964.mp3','','','NS12','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Nơi Mình Dừng Chân','https://i.scdn.co/image/ab67616d0000b27368511be9db8b6a266e261241','Mỹ Tâm','https://www.mboxdrive.com/Noi%20Minh%20Dung%20Chan%20-%20My%20Tam.mp3','','','NS12','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Người Hãy Quên Em Đi','https://afamilycdn.com/2018/photo-2-1515141754394.png','Mỹ Tâm','https://www.mboxdrive.com/Nguoi%20Hay%20Quen%20Em%20Di%20Please%20Fo...%20-%20My%20Tam%20(NhacPro.net).mp3','','','NS12','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Muộn Màng Là Từ Lúc Nào','https://amatrendy.net/cdn1/images/202105/thumb_article/loi-bai-hat-muon-mang-la-tu-luc---my-tam-thumb-1621191916.jpg','Mỹ Tâm','https://www.mboxdrive.com/Muon%20Mang%20La%20Tu%20Luc%20-%20My%20Tam.mp3','','','NS12','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'See You Again','https://reedleygoodshepherd.com/wp-content/uploads/2019/06/image4-6.jpg','Charlie Puth','https://www.mboxdrive.com/SeeYouAgainFeatCharliePuth-WizKhalifa-6426109.mp3','','','NS13','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Attention','https://www.voca.vn/assets/img/news/loi-dich-bai-hat-attention1591604460.jpeg','Charlie Puth','https://www.mboxdrive.com/Attention-CharliePuth-6429177.mp3','','','NS13','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'We Dont Talk Anymore','https://file.tinnhac.com/resize/600x-/2016/09/22/anymore2-d362.jpeg','Charlie Puth','https://www.mboxdrive.com/WeDonTTalkAnymoreFeatSelenaGomez-CharliePuth-6426101.mp3','','','NS13','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'One Call Away','https://i0.wp.com/www.loibaihat.net/wp-content/uploads/2017/09/onecallaway-charlieputh.jpg?fit=950%2C950&ssl=1','Charlie Puth','https://data3.chiasenhac.com/downloads/1748/5/1747526-a9083b26/128/One%20Call%20Away%20-%20Charlie%20Puth.mp3','','','NS13','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Marvin Gaye','https://i0.wp.com/www.loibaihat.net/wp-content/uploads/2017/09/onecallaway-charlieputh.jpg?fit=950%2C950&ssl=1','Charlie Puth','https://www.mboxdrive.com/Marvin%20Gaye%20-%20Charlie%20Puth_%20Meghan%20Train.mp3','','','NS13','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'How You Like That','https://image.thanhnien.vn/1200x630/Uploaded/2022/mtfqu/2021_11_12/blackpink-7206.jpeg','BlackPink','https://www.mboxdrive.com/HowYouLikeThat-BLACKPINK-6720100.mp3','','','NS14','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Kill This Love','https://preview.redd.it/isp52tl04cg61.jpg?width=640&crop=smart&auto=webp&s=1524f611c5bdb3a469c06c86cf71b543bb20fd26','BlackPink','https://www.mboxdrive.com/KillThisLove-BLACKPINK-6291967.mp3','','','NS14','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'DDu-Du DDu-Du','https://i.pinimg.com/originals/97/9d/75/979d75b714d38d3de8293735750f8c45.jpg','BlackPink','https://www.mboxdrive.com/DduduDdudu-BLACKPINK-6291998.mp3','','','NS14','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'BoomBayAh','https://bloganchoi.com/wp-content/uploads/2020/03/bai-hat-boombayah.jpg','BlackPink','https://www.mboxdrive.com/Boombayah-BLACKPINK-6291993.mp3','','','NS14','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Lovesick Girls','https://kenh14cdn.com/thumb_w/600/2020/9/28/title-1601252334466111817993-crop-16012525383801506790019.jpeg','BlackPink','https://www.mboxdrive.com/LovesickGirls-BLACKPINK-6720104.mp3','','','NS14','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Đau Nhất Là Lặng Im','https://i.ytimg.com/vi/RA2nGgEClvE/maxresdefault.jpg','Erik','https://data.chiasenhac.com/down2/2226/5/2225097-2133e315/128/Dau%20Nhat%20La%20Lang%20Im%20-%20Erik.mp3','','','NS15','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Em Không Sai, Chúng Ta Sai','https://image.thanhnien.vn/w1024/Uploaded/2022/noktnz/2020_05_14/hoa-hau-tieu-vy-xuat-hien-trong-mv-cua-erik-13-5-20207_lvzh.jpg','Erik','https://www.mboxdrive.com/EmKhongSaiChungTaSai-ERIK-6272129.mp3','','','NS15','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Dịu Dàng Em Đến','https://i.vietgiaitri.com/2021/8/29/tung-teaser-mv-diu-dang-em-den-phia-erik-phan-hoi-ve-lum-xum-dao-nhai-logo-717-5993967.jpg','Erik','https://www.mboxdrive.com/DiuDangEmDen-ERIKNinjaZ-7078877.mp3','','','NS15','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Lạc Nhau Có Phải Muôn Đời','https://cdn.baogiaothong.vn/files/van.ho/2017/01/19/1_36652-0637-0848.jpg','Erik','https://www.mboxdrive.com/LacNhauCoPhaiMuonDoiMovieVersionChoEmDenNgayMaiOST-ERIKST319-4724804.mp3','','','NS15','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Đừng Xin Lỗi Nữa','https://avatar-ex-swe.nixcdn.com/song/share/2019/01/22/9/6/f/6/1548126937179.jpg','Erik','https://www.mboxdrive.com/DungXinLoiNuaDontSaySorry-ERIKMIN-5355218.mp3','','','NS15','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Kiss Me More','https://avatar-ex-swe.nixcdn.com/song/2021/04/09/d/9/d/6/1617948771476_640.jpg','Doja Cat','https://www.mboxdrive.com/KissMeMore-DojaCatSZA-6999624.mp3','','','NS16','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Say So','https://billboardvn.vn/wp-content/uploads/2020/05/doja-cat-2.jpg','Doja Cat','https://www.mboxdrive.com/SaySo-DojaCat-6159032.mp3','','','NS16','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Woman','https://gangsworld.com/wp-content/uploads/2021/07/https___d1e00ek4ebabms.cloudfront.net_production_2a336038-203e-418c-8c75-88b570ab74f3.jpg','Doja Cat','https://data.chiasenhac.com/down2/2178/5/2177453-c6c6c4fa/128/Woman%20-%20Doja%20Cat.mp3','','','NS16','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Need To Now','https://gangsworld.com/wp-content/uploads/2021/07/https___d1e00ek4ebabms.cloudfront.net_production_2a336038-203e-418c-8c75-88b570ab74f3.jpg','Doja Cat','https://data.chiasenhac.com/down2/2176/5/2175186-e598e0b5/128/Need%20To%20Know%20-%20Doja%20Cat.mp3','','','NS16','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Streets','https://2sao.vietnamnetjsc.vn/images/2021/10/22/09/58/st1.png','Doja Cat','https://www.mboxdrive.com/Streets-DojaCat-6159036.mp3','','','NS16','','')");
//
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Perfect','https://i1.sndcdn.com/artworks-ypCXCsvpjsSK0rBz-IgrG3Q-t500x500.jpg','Ed Sheeran','https://www.mboxdrive.com/Perfect-EdSheeran-5208784.mp3','','','NS17','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Shape Of You','https://revelogue.com/wp-content/uploads/2020/01/shape-of-you-hinh-anh-2-e1625737934929.jpg','Ed Sheeran','https://www.mboxdrive.com/ShapeOfYou-KnutKippersundLenaHaarberg-5227768.mp3','','','NS17','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Thinking Out Loud','https://ipc.net.vn/wp-content/uploads/2019/01/h%C3%ACnh-1.jpg','Ed Sheeran','https://www.mboxdrive.com/Thinking%20Out%20Loud%20-%20Ed%20Sheeran.mp3','','','NS17','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Photograph','https://wallpaperaccess.com/full/1352013.jpg','Ed Sheeran','https://www.mboxdrive.com/Photograph%20-%20Ed%20Sheeran.mp3','','','NS17','','')");
//        databaseHelper.QueryData("INSERT INTO BaiHat VALUES(null,'Bad Habits','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUQANaU4xr-ZKaDHJ4GaQW0qWi13ZOkrhOD-so9BFXNkZDv2JNHop4O73tHvvJk_dZIB4&usqp=CAU','Ed Sheeran','https://data.chiasenhac.com/down2/2178/5/2177603-ac12fe38/128/Bad%20Habits%20-%20Ed%20Sheeran.mp3','','','NS17','','')");





















        final LoadingDialog loadingDialog = new LoadingDialog(TrangChuActivity.this);
        AnhXa();
        loadingDialog.StartLoadingDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissDialog();
            }
        }, 7500);
        init();
        overridePendingTransition(R.anim.anim_intent_in_home, R.anim.anim_intent_out);

        
    }
    private void AnhXa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(), "");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem(), "");
        mainViewPagerAdapter.addFragment(new Fragment_Thu_Vien(), "");
//        mainViewPagerAdapter.addFragment(new Fragment_Profile(), "");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
        tabLayout.getTabAt(2).setIcon(R.drawable.iconthuvien);
//        tabLayout.getTabAt(3).setIcon(R.drawable.iconlogo);
    }

}
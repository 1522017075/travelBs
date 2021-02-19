package com.fanjie.travel.service.Impl;

import com.fanjie.travel.mapper.TravelUserMapper;
import com.fanjie.travel.model.dto.UserDTO;
import com.fanjie.travel.model.vo.UserVO;
import com.fanjie.travel.service.MailService;
import com.fanjie.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TravelUserMapper travelUserMapper;

    @Autowired
    private MailService mailService;

    @Override
    public List<UserDTO> selectByPhone(UserVO vo) {
        List<UserDTO> userDTOS = travelUserMapper.selectByPhone(vo);
        return userDTOS;
    }

    @Override
    public List<UserDTO> selectByPhoneAndPass(UserVO vo) {
        List<UserDTO> userDTOS = travelUserMapper.selectByPhoneAndPass(vo);
        return userDTOS;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserVO vo) {
        return travelUserMapper.insert(vo);
    }

    @Override
    public List<UserDTO> selectAll() {
        return travelUserMapper.selectAll();
    }

    @Override
    public List<UserDTO> selectAllBySelect(String str) {
        return travelUserMapper.selectAllBySelect(str);
    }

    @Override
    public int updateByPrimaryKey(UserVO vo) {
        return travelUserMapper.updateByPrimaryKey(vo);
    }

    @Override
    public int getCode(UserVO vo) {
        String to = vo.getMail();
        String title = "您的晋祠旅游网站账号验证码！";
        String code = getFourRandom();
        mailService.simpleSendMail(to, title,
                "验证码为：" + code + "，请尽快进行验证！");
        int codeNum = Integer.valueOf(code).intValue();
        return codeNum;
    }

    /**
     * 产生4位随机数(0000-9999)
     * @return 4位随机数
     */
    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0" + fourRandom  ;
        }
        return fourRandom;
    }
}

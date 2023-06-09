package com.jobtang.sourcecompany.api.community.dto;

import com.jobtang.sourcecompany.api.community.entity.Community;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ReadAllCommunityResponse {
  private Long communityId;
  private String title;
  private String userName;
  private String date ;
  private String time ;
  private int viewCount;
  private int likesCount;
  private int commentCount;
  private String communityType;
  public static ReadAllCommunityResponse EntityToDTO (Community community , int viewCount){
    return ReadAllCommunityResponse.builder()
            .communityId(community.getId())
            .title(community.getTitle())
            .date(community.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
            .time(community.getCreatedDate().format(DateTimeFormatter.ofPattern("HH:mm")))
            .userName(community.getUser().getNickname())
            .viewCount(viewCount+community.getTotalView()+community.getYesterdayView())
            .likesCount(community.getLikesCnt())
            .communityType(  (community.getCommunityType()).equals("자유") ?"freeboard" :"corpboard" )
            .commentCount(community.getComments().stream().filter(comment -> !comment.getContent().equals("삭제된 댓글 입니다.") && comment.isActive()==true).collect(Collectors.toList()).size())
            .build();
  }



}

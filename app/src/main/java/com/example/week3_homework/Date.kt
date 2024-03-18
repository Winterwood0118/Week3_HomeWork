package com.example.week3_homework

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
//시간 관련 전역 변수로 지정
val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
val localDateTime = LocalDateTime.now()
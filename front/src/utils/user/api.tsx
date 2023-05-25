import axios from "axios";
import { SERVER_URL } from "../url";

export const idCheckAxios = async (id: string) => {
  try {
    const response = await axios.get(SERVER_URL + `/user/validusername/${id}`);
    return response.data;
  } catch (error) {
    return null;
  }
};

export const nickNameCheckAxios = async (nickName: string) => {
  try {
    const response = await axios.get(
      SERVER_URL + `/user/validnickname/${nickName}`
    );
    return response.data;
  } catch (error) {
    return null;
  }
};

export const signUpAxios = async (
  birth: string,
  email: string,
  nickName: string,
  password: string,
  sex: string
) => {
  try {
    const response = await axios.post(SERVER_URL + `/user/signup`, {
      birth,
      email,
      nickname: nickName,
      password,
      sex,
    });
    return response;
  } catch (error) {
    return null;
  }
};

export const loginAxios = async (id: string, password: string) => {
  console.log("44444444444444444444444444444444444444444");
  try {
    const response = await axios.post(SERVER_URL + `/user/login`, {
      email: id,
      password,
    });
    console.log(response);
    console.log("5555555555555555555555555");
    return response.data.data;
  } catch (error) {
    console.log(error);
    console.log("66666666666666666666666666666666666666666");
    return null;
  }
};

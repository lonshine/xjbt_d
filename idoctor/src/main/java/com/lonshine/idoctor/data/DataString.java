package com.lonshine.idoctor.data;

/**
 * Created by lonshine on 15/11/17 下午11:29.
 */
public class DataString {


    public final static String JSON = "{\"id\":1001,\n" +
            "\"name\":\"乳腺检查\",\n" +
            "\"data\":[{\"id\":10001,\n" +
            "\"name\":\"组织成分\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":1,\n" +
            "\"is_child\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"check_list\":[{\"id\":100000,\n" +
            "\"name\":\"均质\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":3,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[100001,\n" +
            "100002,\n" +
            "100003],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100001,\n" +
            "\"name\":\"腺体型\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100000,\n" +
            "\"parent_name\":\"均质\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100002,\n" +
            "\"name\":\"腺纤维I型、II型\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100000,\n" +
            "\"parent_name\":\"均质\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100003,\n" +
            "\"name\":\"脂肪型\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100000,\n" +
            "\"parent_name\":\"均质\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100004,\n" +
            "\"name\":\"不均质\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"process_index\":\"A\",\n" +
            "\"child_index\":\"\"},\n" +
            "{\"id\":10002,\n" +
            "\"name\":\"形状\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":0,\n" +
            "\"is_child\":1,\n" +
            "\"parent_id\":10002,\n" +
            "\"parent_name\":\"肿块\",\n" +
            "\"check_list\":[{\"id\":100005,\n" +
            "\"name\":\"椭圆形\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":1}},\n" +
            "{\"id\":100006,\n" +
            "\"name\":\"圆形\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":1,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":1}},\n" +
            "{\"id\":100007,\n" +
            "\"name\":\"不规则形\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":1,\n" +
            "\"gokalp_g\":1,\n" +
            "\"lvguorong\":1,\n" +
            "\"lee_hj_main\":1,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"占位性病变且可以在两个不同的切面上看到\",\n" +
            "\"parent\":{\"id\":10002,\n" +
            "\"name\":\"肿块\",\n" +
            "\"checkable\":0,\n" +
            "\"multi_check\":0,\n" +
            "\"describe\":\"占位性病变且可以在两个不同的切面上看到\"},\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"process_index\":\"B\",\n" +
            "\"child_index\":\"1\"},\n" +
            "{\"id\":10004,\n" +
            "\"name\":\"位相\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":0,\n" +
            "\"is_child\":1,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"肿块\",\n" +
            "\"check_list\":[{\"id\":100008,\n" +
            "\"name\":\"平行\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":1}},\n" +
            "{\"id\":100009,\n" +
            "\"name\":\"不平行\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":1,\n" +
            "\"costanini_m\":1,\n" +
            "\"gokalp_g\":1,\n" +
            "\"lvguorong\":1,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{\"id\":10002,\n" +
            "\"name\":\"肿块\",\n" +
            "\"checkable\":0,\n" +
            "\"multi_check\":0,\n" +
            "\"describe\":\"占位性病变且可以在两个不同的切面上看到\"},\n" +
            "\"process_index\":\"B\",\n" +
            "\"child_index\":\"2\"},\n" +
            "{\"id\":10005,\n" +
            "\"name\":\"边缘\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":0,\n" +
            "\"is_child\":1,\n" +
            "\"parent_id\":10002,\n" +
            "\"parent_name\":\"肿块\",\n" +
            "\"check_list\":[{\"id\":100010,\n" +
            "\"name\":\"光整\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":1}},\n" +
            "{\"id\":100011,\n" +
            "\"name\":\"不光整\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":4,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[100012,\n" +
            "100013,\n" +
            "100014,\n" +
            "100015],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":1,\n" +
            "\"lvguorong\":1,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100012,\n" +
            "\"name\":\"模糊\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100011,\n" +
            "\"parent_name\":\"不光整\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100013,\n" +
            "\"name\":\"成角\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100011,\n" +
            "\"parent_name\":\"不光整\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":1,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100014,\n" +
            "\"name\":\"微小分叶\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100011,\n" +
            "\"parent_name\":\"不光整\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":1,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100015,\n" +
            "\"name\":\"毛刺状\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100011,\n" +
            "\"parent_name\":\"不光整\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":1,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{\"id\":10002,\n" +
            "\"name\":\"肿块\",\n" +
            "\"checkable\":0,\n" +
            "\"multi_check\":0,\n" +
            "\"describe\":\"占位性病变且可以在两个不同的切面上看到\"},\n" +
            "\"process_index\":\"B\",\n" +
            "\"child_index\":\"3\"},\n" +
            "{\"id\":10006,\n" +
            "\"name\":\"回声类型\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":0,\n" +
            "\"is_child\":1,\n" +
            "\"parent_id\":10002,\n" +
            "\"parent_name\":\"肿块\",\n" +
            "\"check_list\":[{\"id\":100016,\n" +
            "\"name\":\"无回声\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100017,\n" +
            "\"name\":\"高回声\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100018,\n" +
            "\"name\":\"混合性回声\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100019,\n" +
            "\"name\":\"低回声\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100020,\n" +
            "\"name\":\"内部等回声\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100021,\n" +
            "\"name\":\"内部 不均质\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":1,\n" +
            "\"lvguorong\":1,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{\"id\":10002,\n" +
            "\"name\":\"肿块\",\n" +
            "\"checkable\":0,\n" +
            "\"multi_check\":0,\n" +
            "\"describe\":\"占位性病变且可以在两个不同的切面上看到\"},\n" +
            "\"process_index\":\"B\",\n" +
            "\"child_index\":\"4\"},\n" +
            "{\"id\":10007,\n" +
            "\"name\":\"后方回声特征\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":0,\n" +
            "\"is_child\":1,\n" +
            "\"parent_id\":10002,\n" +
            "\"parent_name\":\"肿块\",\n" +
            "\"check_list\":[{\"id\":100022,\n" +
            "\"name\":\"后方回声无特征\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100023,\n" +
            "\"name\":\"增强\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100024,\n" +
            "\"name\":\"声影\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":1,\n" +
            "\"costanini_m\":1,\n" +
            "\"gokalp_g\":1,\n" +
            "\"lvguorong\":1,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100025,\n" +
            "\"name\":\"混合模式\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{\"id\":10002,\n" +
            "\"name\":\"肿块\",\n" +
            "\"checkable\":0,\n" +
            "\"multi_check\":0,\n" +
            "\"describe\":\"占位性病变且可以在两个不同的切面上看到\"},\n" +
            "\"process_index\":\"B\",\n" +
            "\"child_index\":\"5\"},\n" +
            "{\"id\":10008,\n" +
            "\"name\":\"周围组织\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":1,\n" +
            "\"is_child\":1,\n" +
            "\"parent_id\":10002,\n" +
            "\"parent_name\":\"肿块\",\n" +
            "\"check_list\":[{\"id\":100026,\n" +
            "\"name\":\"可识别的效应（选择所有相适应的）\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100027,\n" +
            "\"name\":\"导管变化\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":1,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100028,\n" +
            "\"name\":\"Cooper’s韧带变化\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100029,\n" +
            "\"name\":\"水肿\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100030,\n" +
            "\"name\":\"结构变形\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100031,\n" +
            "\"name\":\"皮肤增厚\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":1,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[100032],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100032,\n" +
            "\"name\":\"皮肤凹陷或不规则\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"如果存在（选择所有适应的）\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{\"id\":10002,\n" +
            "\"name\":\"肿块\",\n" +
            "\"checkable\":0,\n" +
            "\"multi_check\":0,\n" +
            "\"describe\":\"占位性病变且可以在两个不同的切面上看到\"},\n" +
            "\"process_index\":\"B\",\n" +
            "\"child_index\":\"6\"},\n" +
            "{\"id\":10009,\n" +
            "\"name\":\"边界\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":0,\n" +
            "\"is_child\":1,\n" +
            "\"parent_id\":10002,\n" +
            "\"parent_name\":\"肿块\",\n" +
            "\"check_list\":[{\"id\":100033,\n" +
            "\"name\":\"清晰\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":1,\n" +
            "\"gokalp_g_ok\":1}},\n" +
            "{\"id\":100034,\n" +
            "\"name\":\"不清晰\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":1,\n" +
            "\"gokalp_g\":1,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{\"id\":10002,\n" +
            "\"name\":\"肿块\",\n" +
            "\"checkable\":0,\n" +
            "\"multi_check\":0,\n" +
            "\"describe\":\"占位性病变且可以在两个不同的切面上看到\"},\n" +
            "\"process_index\":\"B\",\n" +
            "\"child_index\":\"7\"},\n" +
            "{\"id\":10010,\n" +
            "\"name\":\"钙化\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":0,\n" +
            "\"is_child\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"0\",\n" +
            "\"check_list\":[{\"id\":100035,\n" +
            "\"name\":\"粗钙化\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100036,\n" +
            "\"name\":\"微钙化\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":3,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[100037,\n" +
            "100038,\n" +
            "100039],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100037,\n" +
            "\"name\":\"病变外的微钙化\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100036,\n" +
            "\"parent_name\":\"微钙化\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100038,\n" +
            "\"name\":\"病变内的微钙化\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100036,\n" +
            "\"parent_name\":\"微钙化\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":1,\n" +
            "\"lvguorong\":1,\n" +
            "\"lee_hj_main\":1,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100039,\n" +
            "\"name\":\"乳腺导管内钙化\",\n" +
            "\"is_child\":1,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":100036,\n" +
            "\"parent_name\":\"微钙化\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"如果存在（选择所有适应的）\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{},\n" +
            "\"process_index\":\"C\"},\n" +
            "{\"id\":10011,\n" +
            "\"name\":\"相关特征如果存在（选择所有适应的）\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":1,\n" +
            "\"is_child\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"0\",\n" +
            "\"check_list\":[{\"id\":100040,\n" +
            "\"name\":\"结构扭曲\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":1,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100041,\n" +
            "\"name\":\"导管改变\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":1,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100042,\n" +
            "\"name\":\"皮肤改变\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100043,\n" +
            "\"name\":\"水肿\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100044,\n" +
            "\"name\":\"血供情况\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100045,\n" +
            "\"name\":\"弹性\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{},\n" +
            "\"process_index\":\"D\"},\n" +
            "{\"id\":10012,\n" +
            "\"name\":\"特殊情况\",\n" +
            "\"checkable\":1,\n" +
            "\"multi_check\":1,\n" +
            "\"is_child\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"0\",\n" +
            "\"check_list\":[{\"id\":100046,\n" +
            "\"name\":\"簇状微囊肿\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100047,\n" +
            "\"name\":\"复杂囊肿\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":1,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100048,\n" +
            "\"name\":\"皮内或皮肤表面的肿物\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100049,\n" +
            "\"name\":\"异物\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100050,\n" +
            "\"name\":\"乳腺内淋巴结\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100051,\n" +
            "\"name\":\"腋窝淋巴结\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[0],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100052,\n" +
            "\"name\":\"单纯囊肿\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100053,\n" +
            "\"name\":\"血管异常\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100054,\n" +
            "\"name\":\"术后积液\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}},\n" +
            "{\"id\":100055,\n" +
            "\"name\":\"脂肪坏死\",\n" +
            "\"is_child\":0,\n" +
            "\"child_count\":0,\n" +
            "\"parent_id\":0,\n" +
            "\"parent_name\":\"\",\n" +
            "\"child_id_list\":[],\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0}}],\n" +
            "\"describe\":\"如果存在（选择所有适应的）\",\n" +
            "\"treat_result_code\":{\"lee_hj\":0,\n" +
            "\"costanini_m\":0,\n" +
            "\"gokalp_g\":0,\n" +
            "\"lvguorong\":0,\n" +
            "\"lee_hj_main\":0,\n" +
            "\"costanini_m_ok\":0,\n" +
            "\"gokalp_g_ok\":0},\n" +
            "\"parent\":{},\n" +
            "\"process_index\":\"E\"}]}";

}

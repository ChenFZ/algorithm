/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: SysUser
 * Author:   chenfz
 * Date:     2021/9/9 11:09
 * Description: test lombok
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.testlombok;

import lombok.*;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test lombok〉
 *
 * @author chenfz
 * @create 2021/9/9
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class SysUserEntity implements Serializable {


}

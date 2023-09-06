export function formatDate(mode = "ch", style = "full", moreOrLess?: number) {
  let date = new Date();
  if (moreOrLess !== undefined) {
    date.setMilliseconds(date.getMilliseconds() + moreOrLess);
  }
  let formated = "";
  if (mode === "ch") {
    if (style === "full") {
      formated =
        date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日" + date.getHours() + "时" + date.getMinutes();
    } else if (style === "month") {
      formated = date.getMonth() + 1 + "月" + date.getDate() + "日" + date.getHours() + "时" + date.getMinutes();
    } else if (style === "day") {
      formated = date.getMonth() + 1 + "月" + date.getDate() + "日";
    } else if (style === "hours") {
      formated = date.getHours() + "时" + date.getMinutes();
    }
  } else if (mode === "line") {
    if (style === "full") {
      formated = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes();
    } else if (style === "month") {
      formated = date.getMonth() + 1 + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes();
    } else if (style === "day") {
      formated = date.getMonth() + 1 + "-" + date.getDate();
    } else if (style === "hours") {
      formated = date.getHours() + ":" + date.getMinutes();
    }
  }
  return formated;
}

/**
 * 除了最后一个元素以外，数组中的每一个元素末尾处都拼接一个特定的字符。
 *
 * @param Object character 拼接的字符
 * @param Array target 目标数组
 */
export function concatWith(character = ",", target: any[]) {
  let concated = "";
  if (!target) return concated;
  for (let i = 0; i < target.length; i++) {
    if (target.length === i + 1) {
      concated += target[i];
    } else {
      concated += target[i] + character;
    }
  }
  return concated;
}

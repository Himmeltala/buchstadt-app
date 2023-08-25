import { defineConfig, presetAttributify, presetUno, presetTypography } from "unocss";
import transformerDirectives from "@unocss/transformer-directives";

const flexMathces = [
  { prefix: "c", value: "center" },
  { prefix: "s", value: "start" },
  { prefix: "e", value: "end" },
  { prefix: "b", value: "between" }
];

export default defineConfig({
  presets: [presetUno(), presetAttributify(), presetTypography()],
  transformers: [
    transformerDirectives({
      applyVariable: "--uno"
    })
  ],
  rules: [
    [/^size-(\d*)([a-z]*)$/, ([, d, uint]) => ({ "font-size": `${d}${uint}` })],
    [/^flow-(auto|hidden|inherit|initial|overlay|revert|scroll|unset|visible)$/, ([, d]) => ({ overflow: `${d}` })],
    [/^flow-x-(auto|hidden|inherit|initial|overlay|revert|scroll|unset|visible)$/, ([, d]) => ({ overflow: `${d}` })],
    [/^flow-y-(auto|hidden|inherit|initial|overlay|revert|scroll|unset|visible)$/, ([, d]) => ({ overflow: `${d}` })]
  ],
  shortcuts: [
    [
      /^f-((c|s|e)(-(c|s|e|b))*)$/,
      ([, , p1, , p2]) => {
        let style = ``;

        let matchedVal = flexMathces.find(i => i.prefix === p1);
        style += `flex items-${matchedVal?.value || "center"} content-${matchedVal?.value || "center"}`;

        if (p2) {
          matchedVal = flexMathces.find(i => i.prefix === p2);
          style += ` justify-${matchedVal?.value || "center"}`;
        }

        return style;
      }
    ]
  ]
});

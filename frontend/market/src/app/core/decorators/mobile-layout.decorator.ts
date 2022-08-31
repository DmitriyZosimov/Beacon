export function MobileLayout(isMobileLayout: string = 'isMobileLayout') {
  return (constructor: any) => {
    const original = constructor.prototype.onResize;
    constructor.prototype.onResize = function (): void {
      this[isMobileLayout] = window.screen.width <= 786;

      if (original && (typeof original === 'function')) {
        original.apply(this, arguments);
      }
    };
  };
}
